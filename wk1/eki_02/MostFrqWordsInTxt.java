import java.util.HashSet;

public class MostFrqWordsInTxt
{
    public static String frqWords(String seq, int k)
    {
        HashSet<String> frqPrtn = new HashSet<String>();
        String ptrn, output = "";
        int[] count = new int[seq.length() - k +1 ];
        int max = 0;
        //loop and searcn for ptrn freq
        for(int i=0; i< seq.length() - k + 1; i++)
        {
            ptrn = seq.substring(i, i+k);
            count[i] = count(seq, ptrn);
        }
        //find max value
        for(int val : count)
        {
            if(val>max) max = val;
        }
        for(int i=0; i<count.length; i++)
        {
            if(count[i] == max)
            {
                ptrn = seq.substring(i, i+k);
                frqPrtn.add(ptrn);
            }
        }
        //stringify the results
       for(String str : frqPrtn)
        {
            output += str + " ";
        }
        return output;
    }

    public static int count(String seq, String ptrn)
    {
        int count = 0;
        for(int i=0; i<seq.length()-ptrn.length() + 1; i++)
        if( seq.substring(i, i+ptrn.length()).compareTo(ptrn) == 0 ) count++;
        return count;
    }
}