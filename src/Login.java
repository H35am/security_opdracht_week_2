/**
 * Created by Hesam Zarza - 0775768.
 */

import com.sun.org.apache.xpath.internal.SourceTree;
import sun.plugin2.message.Message;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Login {

    public static void main(String[] Args) throws NoSuchAlgorithmException, UnsupportedEncodingException {


        Scanner scan = new Scanner (new File(files/login.txt));
        System.out.println(scan);
        //String user = scan.nextLine();
        //String pass = scan.nextLine(); // looks at selected file in scan

        BufferedReader testingDoc = getFileReader("files/login.txt");



        Scanner keyboard = new Scanner (System.in);
        String inpUser = keyboard.nextLine();
        String inpPass = keyboard.nextLine(); // gets input from user

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        String text = inpUser+inpPass;
        md.update( text.getBytes("UTF-8") );

        byte[] digest = md.digest();

        String s = String.format("%064x", new java.math.BigInteger(1, digest));
        System.out.println(s);

        System.out.println(text);

       /*if (inpUser.equals(s) && inpPass.equals()) {
            System.out.print("your login message");
       } else {
           System.out.print("your error message");
       }*/

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