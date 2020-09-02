public class PtnCountInTxt
{
    //count nbr of ptn matching
    public static int ptnCount(String seq, String ptn)
    {
        System.out.println();
        String chunks = "";
        int count = 0;
        for(int i=0; i<seq.length()-ptn.length() + 1; i++)
        {
            if( seq.substring(i, i+ptn.length()).compareTo(ptn) == 0 ) count++;
            //System.out.println(seq.substring(i, i + ptn.length()));
            chunks += seq.substring(i, i + ptn.length()) + "\n";
        }

        System.out.println(chunks);

        System.out.println();

        return count;
    }
}


/*
Code Challenge: Implement PatternCount (reproduced below).
     Input: Strings Text and Pattern.
     Output: Count(Text, Pattern).

    PatternCount(Text, Pattern)
        count ← 0
        for i ← 0 to |Text| − |Pattern|
            if Text(i, |Pattern|) = Pattern
                count ← count + 1
        return count
*/