import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File input;
        try
        {
            input = new File(args[0]);
        }catch(Exception e)
        {
            System.out.println("Usage: program input.txt");
            return;
        }

        Scanner scanner = new Scanner(input);
        String sequence = scanner.next();
        scanner.close();

        String output = GetOriFromSkewDiagram.getMinimun(sequence);

        System.out.println(output);

        File outputFile = new File("output.txt");

        if( !outputFile.exists() ) outputFile.createNewFile();

        PrintWriter writer = new PrintWriter(outputFile);

        writer.print(output);

        writer.close();
    }
}