import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        if(args.length<1)
        {
            System.out.println("Usage: program input.txt");
            return;
        }

        /* get input */

        File input = new File(args[0]);

        Scanner scan = new Scanner(input);

        int k = scan.nextInt();
        int d = scan.nextInt();
        ArrayList<String> Dna = new ArrayList<>();
        String buff;
        while( scan.hasNext() )
        {
            buff = scan.next();
            Dna.add(buff);
        }

        scan.close();

        /* fnx */
        List<String> out = BruteForce_motifFinding.motifEnumeration(Dna, k, d);

        /* write output */

        File output = new File("output.txt");

        if(!output.exists()) output.createNewFile();

        PrintWriter write = new PrintWriter(output);

        buff = "";
        for(String str : out)
        {
           buff += str + " ";
        }
        
        buff.trim();
        System.out.println(buff);
        write.print(buff);
        
        write.close();
    }
}