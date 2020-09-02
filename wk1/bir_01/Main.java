import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class Main {
    public static void main(String[] args) throws FileNotFoundException
    {
        // read contents of file
        File file = new File(args[0]);
        Scanner scanner = new Scanner(file);
        
        /* if wanna read whole content
        scanner.useDelimiter("\\Z");
        String content = scanner.next();
        System.out.println(content);
        */

        //read sequence and ptn
        String sequence = scanner.next();
        String ptn = scanner.next();

        System.out.println("Sequence is: " + sequence + "\n" + 
                            "pattern is: " + ptn);

        scanner.close();

        //run fnx; pseudocode is in the end
        int count = PtnCountInTxt.ptnCount(sequence, ptn);

        System.out.println("Matches are: " + count);
    }    
}