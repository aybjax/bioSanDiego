import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        //Scanner scan = new Scanner(System.in);
        File file = new File(args[0]);
        Scanner scan = new Scanner(file);
        String seq = scan.next();
        scan.close();

        String output = ReverseComplement.getComplementString(seq);

        System.out.println("Complement sequence is:\n" + output);

        //write output to file
        File out = new File("out.txt");

        //create if does now exist
        if( !out.exists() )
        {
            out.createNewFile();
        }

        //writing
        PrintWriter writer = new PrintWriter(out);
        writer.print(output);
        writer.close();
    }
}