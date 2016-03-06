/**
 * Created by Hesam Zarza - 0775768.
 */

import java.io.BufferedReader;
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

        Scanner sc = new Scanner("files/login.txt");
        String line = sc.next();

        System.out.println(line);

        sc.close();
        /*
        try {
            Scanner input;
            File file = new File("files/login.txt");

            input = new Scanner(file);
            while (input.hasNextLine()) {
                String line = input.nextLine();
            }
            input.close();
        } catch(Exception ex){
            ex.printStackTrace();
        }
*/


        Scanner keyboard = new Scanner (System.in);
        String inpUser = keyboard.nextLine();
        String inpPass = keyboard.nextLine(); // gets input from user

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        String hashed = inpUser+inpPass;
        md.update( hashed.getBytes("UTF-8") );

        byte[] digest = md.digest();

        String s = String.format("%064x", new java.math.BigInteger(1, digest));

        System.out.println(s);

        Users hesam = new Users("hesam", "ff10b229a15fef22e0dbde72e3bb09e0122926959c06b2c5b6548e437c712dc5");
        Users walter = new Users("walter", "8cee24cc4b77db832c34abb40c41d1cf71566a1fdc20e590733e3f1ab5beb5ed");

        String master = "555";


         if ((hesam.getName().equals(inpUser) && hesam.getPass().equals(s)) || (inpUser.equals(hesam.getName()) && inpPass.equals(master))){
            System.out.print("Success full login yeeeeey!");
       }

     else {
         System.out.print("your error message");
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

/*

        Scanner scan = new Scanner(file);
        //String user = scan.nextLine();
        //String pass = scan.nextLine(); // looks at selected file in scan
        File file = new File("files/login.txt");
        System.out.println(file.exists());

        BufferedReader testingDoc = getFileReader("files/login.txt");
        System.out.println(testingDoc);

        String master = "5994471abb01112afcc18159f6cc74b4f511b99806da59b3caf5a9c173cacfc5";
       if (inpUser.equals(inpUser) && inpPass.equals(inpPass)) {
            System.out.print("your login message");
       }
*/
