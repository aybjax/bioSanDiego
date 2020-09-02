public class SkewArray
{
    public static int[] plotSkewArray(String Genome)
    {
        int len = Genome.length() + 1;

        int[] skewArray = new int[len];
        skewArray[0] = 0;

        for(int i = 0; i<Genome.length(); i++)
        {
            if(Genome.charAt(i) == 'C') len = -1;
            else if(Genome.charAt(i) == 'G') len = 1;
            else len = 0;
            skewArray[i+1] = skewArray[i] + len;
        }

        return skewArray;
    }
}