import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws FileNotFoundException
    {
        //read contents of file
        File file = new File(args[0]);
        Scanner scanner = new Scanner(file);

        //actual files
        String sequence = scanner.next();
        int k = scanner.nextInt();

        scanner.close();

        //pseudocodes are at the end
        String output = MostFrqWordsInTxt.frqWords(sequence, k);

        System.out.println(output);
    }
}



/* PseudoCode
FrequentWords(Text, k)
    FrequentPatterns ← an empty set
    for i ← 0 to |Text| − k
        Pattern ← the k-mer Text(i, k)
        Count(i) ← PatternCount(Text, Pattern)
    maxCount ← maximum value in array Count
    for i ← 0 to |Text| − k
        if Count(i) = maxCount
            add Text(i, k) to FrequentPatterns
    remove duplicates from FrequentPatterns
    return FrequentPatterns
*/