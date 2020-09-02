import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        System.out.println("1st argument is:\n\tptn if ptnToNum;\n\tnum if numToptn");

        String problem = args[0];
        File file = new File(args[1]);
        Scanner scan = new Scanner(file);
        File out = new File("out.txt");

        if(!out.exists()) out.createNewFile();

        PrintWriter writer = new PrintWriter(out);

        numToPtnANDptnToNum indexptns = new numToPtnANDptnToNum();

        if( problem.equals("ptn") )
        {
            String ptn = scan.next();
            long indexOfPtrnArray = numToPtnANDptnToNum.ptnToNum(ptn);
            writer.print(indexOfPtrnArray);
        }else if( problem.equals("num") )
        {
            long index = scan.nextInt();
            int k = scan.nextInt();
            String pattern = numToPtnANDptnToNum.numToPtn(index, k);
            writer.print(pattern);
        }


        writer.close();
        scan.close();
    }
}