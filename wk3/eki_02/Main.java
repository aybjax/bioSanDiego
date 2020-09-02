import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        if(args.length < 1)
        {
            System.out.println("Usage: program input.txt");
            return;
        }

        /* get input */
        File inputFile = new File(args[0]);

        Scanner scanner = new Scanner(inputFile);

        int k = scanner.nextInt();

        List<String> Dna = new ArrayList<>();

        while(scanner.hasNext())
        {
            Dna.add(scanner.next());
        }

        scanner.close();

        /* fnx */
        String out = MedianString.findMedianString(Dna, k);

        /* output */

        File outputFile = new File("output.txt");

        if( !outputFile.exists() ) outputFile.createNewFile();

        PrintWriter writer = new PrintWriter(outputFile);

        writer.print(out);

        writer.close();
    }
}