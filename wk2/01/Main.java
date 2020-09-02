import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File inputFile;
        try
        {
            inputFile = new File(args[0]);
        }catch(Exception e)
        {
            System.out.println("Use: program inputFile.txt");
            return;
        }

        Scanner scan = new Scanner(inputFile);

        String genome = scan.next();

        scan.close();

        int[] skewArray = SkewArray.plotSkewArray(genome);

        String output = "0";

        for(int i=1; i<skewArray.length; i++)
        {
            output += " " + skewArray[i];
        }

        File outputFile = new File("output.txt");

        if( !outputFile.exists() ) outputFile.createNewFile();

        PrintWriter writer = new PrintWriter(outputFile);

        System.out.println(output);
        writer.print(output);
        writer.close();
    }   
}