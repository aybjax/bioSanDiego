import java.util.ArrayList;
import java.util.HashSet;

public class FrqWrdMatchWMismatchesBYSORTING {
    public static HashSet<String> frqWordMismatch(String Genome, int k, int d)
    {//k - k-mer length | d - # of mistatches
        HashSet<String> frqPtn = new HashSet<String>();
        ArrayList<String> nborhood = new ArrayList<String>();
        ArrayList<String> localNeighbr;

        for(int i=0; i<=(Genome.length() - k); i++)
        {
            localNeighbr = Neighborhood.findNeighbors(Genome.substring(i, i+k), d);
            nborhood.addAll(localNeighbr);
        }


        String ptn;
        int num;
        int[] indexes = new int[nborhood.length()];
        int[] count = new int[nborhood.length()];
        for(int i=0; i<nborhood.length(); i++)
        {
            ptn = nborhood.get(i);
            num = numToPtnANDptnToNum.ptnToNum(ptn);
            indexes[i] = num;
            count[i] = 1;
        }

        quickSortAr(indexes, 0, indexes.length-1);

        for(int i=0; i<nborhood.length()-1; i++)
        {
            if(indexes[i] == indexes[i+1]) count[i+1] = count[i] + 1;
        }

        int max = Integer.MIN_VALUE;
        for(int i=0; i<count.length; i++) if(count[i]>max) max = count[i];

        for(int i=0; i<nborhood.length(); i++)
        {
            if(count[i] == max)
            {
                ptn = numToPtnANDptnToNum.numToPtn(index[i], k);
                frqPtn.add(ptn);
            }
        }

        return frqPtn;
    }


    /*

FrequentWordsWithMismatches(Text, k, d)
    FrequentPatterns ← an empty set
        Neighborhoods ← an empty list
        for i ← 0 to |Text| − k
            add Neighbors(Text(i, k), d) to Neighborhoods
        form an array NeighborhoodArray holding all strings in Neighborhoods
        for i ← 0 to |NeighborhoodArray| − 1
            Pattern ← NeighborhoodArray(i) 
            Index(i) ← PatternToNumber(Pattern)
            Count(i) ← 1
        SortedIndex ← Sort(Index)
        for i ← 0 to |Neighborhoods| − 2 
            if SortedIndex(i) = SortedIndex(i + 1)
                Count(i + 1) ← Count(i) + 1
        maxCount ← maximum value in array Count
        for i ← 0 to |Neighborhoods| − 1
            if Count(i) = maxCount
                Pattern ← NumberToPattern(SortedIndex(i), k)
                add Pattern to FrequentPatterns
        return FrequentPatterns

    */

    
    private static void quickSortAr(int[] indexes, int start, int end)
    {
        if(end <= start) return;

        int pivotIndex = partition(indexes, start, end);

        quickSort(indexes, start, pivotIndex-1);
        quickSort(indexes, start, pivotIndex+1);
    }

    private static int partition(int[] indexes, int start, int end)
    {
        Long pivot = indexes[end];
        int i = start, j;

        for(j=start; j<= end; j++)
        {
            if(indexes[j] < pivot || j == end)
            {
                swap(indexes, i, j);
                i++;
            }
        }

        return --i;
    }

    private static void swap(int[] indexes, int i, int j)
    {
        Long tmpLong;
        int tmpInt;

        tmpLong = indexes[j];

        indexes[j] = indexes[i];

        indexes[i] = tmpLong;
    }

}