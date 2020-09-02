import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String gen = "CGGACTCGACAGATGTGAAGAACGACAATGTGAAGACTCGACACGACAGAGTGAAGAGAAGAGGAAACATTGTAA";
        ArrayList<String> out =  ClumpFindingEnhanced.findClumpViaWindows(gen, 5, 50, 4);

        System.out.println(out);
    }
}