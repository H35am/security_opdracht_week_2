/**
 * Created by Hesam Zarza - 0775768.
 */

import com.sun.org.apache.xpath.internal.SourceTree;
import sun.plugin2.message.Message;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Login {

    public static void main(String[] Args) throws NoSuchAlgorithmException, UnsupportedEncodingException {


      /*  Scanner scan = new Scanner (new File("E:\\Hesam files\\Dropbox\\ProjecteN\\src\\login.txt"));

        String user = scan.nextLine();
        String pass = scan.nextLine(); // looks at selected file in scan
*/


        Scanner keyboard = new Scanner (System.in);
        String inpUser = keyboard.nextLine();
        String inpPass = keyboard.nextLine(); // gets input from user

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        String text = inpUser+inpPass;
        md.update( text.getBytes("UTF-8") );

        byte[] digest = md.digest();

        String s = new String(digest);
        System.out.println(s);

        System.out.println(text);

       /* if (inpUser.equals(user) && inpPass.equals(pass)) {
            System.out.print("your login message");
        } else {
            System.out.print("your error message");
        }
*/
    }
}