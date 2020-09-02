import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;


//use here is wrong. as no need to sort two arrays concurrently
public class FrqWrdBySort extends numToPtnANDptnToNum{
    String sequence;
    int k;
    HashSet<String> frqSet = new HashSet<String>();
    ArrayList<Long> indexes = new ArrayList<Long>();
    ArrayList<Integer> count = new ArrayList<Integer>();

    boolean calculated = false;

    public FrqWrdBySort(String sequence, int k)
    {
        this.sequence = sequence;
        this.k = k;
        calcFrq();
    }

    public HashSet<String> getResult()
    {
        if(calculated == true) return frqSet;
        
        return null;
    }

    private void calcFrq()
    {
        calculated = true;
        frqSet.clear();
        indexes.clear();
        count.clear();

        String ptn;
        for(int i=0; i<= (sequence.length() - k); i++)
        {
            ptn = sequence.substring(i, i+k);
            indexes.add( i, ptnToNum(ptn) );
            count.add(i, 1);
        }
        quickSort(indexes, 0, indexes.size()-1);


        for(int i=1; i<= (sequence.length() - k); i++)
        {
            if( indexes.get(i).compareTo(indexes.get(i-1)) == 0 )
            {
                count.set(i, count.get(i) + count.get(i-1));
            }
        }

        int max = Collections.max(count);

        for(int i=0; i<= (sequence.length() - k); i++)
        {
            if( count.get(i) == max)
            {
                ptn = numToPtn(indexes.get(i), k);
                frqSet.add(ptn);
            }
        }
    }

    /*

    FindingFrequentWordsBySorting(Text , k)
            FrequentPatterns ← an empty set
            for i ← 0 to |Text| − k
                Pattern ← Text(i, k)
                Index(i) ← PatternToNumber(Pattern)
                Count(i) ← 1
            SortedIndex ← Sort(Index)
            for i ← 1 to |Text| − k
                if SortedIndex(i) = SortedIndex(i − 1)
                    Count(i) = Count(i − 1) + 1
            maxCount ← maximum value in the array Count
            for i ← 0 to |Text| − k
                if Count(i) = maxCount
                    Pattern ← NumberToPattern(SortedIndex(i), k)
                    add Pattern to the set FrequentPatterns
            return FrequentPatterns

*/

    private void quickSort(ArrayList<Long> indexes, int start, int end)
    {
        if(end <= start) return;

        int pivotIndex = partition(indexes, start, end);

        quickSort(indexes, start, pivotIndex-1);
        quickSort(indexes, start, pivotIndex+1);
    }

    private int partition(ArrayList<Long> indexes, int start, int end)
    {
        Long pivot = indexes.get(end);
        int i = start, j, pivotIndex;

        for(j=start; j<= end; j++)
        {
            if(indexes.get(j).compareTo(pivot) < 0  || j == end)
            {
                swap(indexes, i, j);
                i++;
            }
        }

        return --i;
    }

    private void swap(ArrayList<Long> indexes, int i, int j)
    {
        Long tmpLong;
        int tmpInt;

        tmpLong = indexes.get(j);
        tmpInt = count.get(j);

        indexes.set(j, indexes.get(i));
        count.set(j, count.get(i));

        indexes.set(i, tmpLong);
        count.set(i, tmpInt);
    }
}