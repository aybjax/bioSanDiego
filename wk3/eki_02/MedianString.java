import java.util.List;

public class MedianString {
    public static String findMedianString( List<String> Dna, int k )
    {
        int dist = Integer.MAX_VALUE;
        String median="", ptn = "";
        double countUpTo = Math.pow(4, k);
        int tmp = 0;
        for(int i=0; i<countUpTo; i++)
        {
            ptn = numToPtnANDptnToNum.numToPtn(i, k);
            tmp = d(ptn, Dna);
            if(dist > tmp)
            {
                dist = tmp;
                median = ptn;
            }
        }

        return median;
    }


    private static int d(String ptn, List<String> Dna)
    {
        int sum = 0, minDist;
        for(String str : Dna)
        {
            minDist = minHammingDist(ptn, str);
            sum += minDist;
        }

        return sum;
    }


    private static int minHammingDist(String ptn, String str)
    {
        int min = Integer.MAX_VALUE;
        int tmp, len = str.length() - ptn.length();
        int k = ptn.length();
        String tmpString;
        for(int i=0; i <= len; i++)
        {
            tmpString = str.substring(i, i+k);
            tmp = HammingDist.findHammingDist(ptn, tmpString);
            min = Math.min(min, tmp);
        }

        return min;
    }

}


/*

    MedianString(Dna, k)
        distance ← ∞
        for each k-mer Pattern from AA…AA to TT…TT
            if distance > d(Pattern, Dna)
                 distance ← d(Pattern, Dna)
                 Median ← Pattern
        return Median

*/