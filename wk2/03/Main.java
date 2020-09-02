import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException
    {
        File input = new File(args[0]);

        Scanner scanner = new Scanner(input);

        String dna = scanner.next();

        scanner.close();

        ArrayList<String> out = Neighborhood.findNeighbors(dna, 1);

        String txtOut = "";
        for(String s: out)
        {
            System.out.print(s + " ");
            txtOut += s + " ";
        }
        txtOut.trim();
        System.out.println();

        File output = new File("output.txt");
        if( !output.exists() ) output.createNewFile();
        PrintWriter writer = new PrintWriter(output);

        writer.print(txtOut);
        writer.close();
    }
}