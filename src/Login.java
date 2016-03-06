/**
 * Created by Hesam Zarza - 0775768.
 */

import com.sun.org.apache.xpath.internal.SourceTree;
import sun.plugin2.message.Message;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Login {

    public static String[] getUserData(String f, String username) throws IOException {
        String[] ud = {"",""};

        BufferedReader br = new BufferedReader(new FileReader(f));
        String line = null;
        while ((line = br.readLine()) != null)
        {
            ud = line.split(",");
            if(ud[0].equals(username)){
                break;
            }

        }

        return ud;
    }



    public static void main(String[] Args) throws NoSuchAlgorithmException, IOException {

        String filename = "files/login.txt";

        Scanner keyboard = new Scanner (System.in);
        String inpUser = keyboard.nextLine();
        String inpPass = keyboard.nextLine(); // gets input from user

        // get uderdata from the file
        String[] userdata = getUserData(filename, inpUser);



        MessageDigest md = MessageDigest.getInstance("SHA-256");
        String text = inpUser+inpPass;
        md.update( text.getBytes("UTF-8") );

        byte[] digest = md.digest();

        String sha = String.format("%064x", new java.math.BigInteger(1, digest));

        if (inpUser.equals(userdata[0]) && sha.equals(userdata[1])) {
            System.out.print("Wellcome "+inpUser);
        } else {
           System.out.print("Login failure ...");
            System.out.println(inpUser + " - " +userdata[0] );
            System.out.println(sha + " - " +userdata[1] );
        }

    }

    private static BufferedReader getFileReader(String file) {
        try {
            return Files.newBufferedReader(Paths.get(file), StandardCharsets.ISO_8859_1);
        } catch (IOException ioe) {
            System.err.println("err: " + ioe);
        }
        return null;
    }



}