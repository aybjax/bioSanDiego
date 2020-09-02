public class ApproxPtnMatching {
    //fill in your ApproximatePatternMatching() function here with any subroutines you need.
    public static List<Integer> ApproximatePatternMatching(String text, String pattern, int match) {
        List<Integer> ret = new ArrayList<Integer>();
        String ptn;
        for(int i=0; i<=( text.length() - pattern.length() ); i++)
        {
            ptn = text.substring(i, i + pattern.length());
            if( findHammingDist(pattern, ptn) <= match )
                ret.add(i);
        }
        return ret;
    }


    public static int findHammingDist(String str1, String str2)
        {
            if( str1.length() != str2.length() ) return -1;

            int dist = 0;

            for(int i=0; i<str1.length(); i++)
            {
                if( str1.charAt(i) != str2.charAt(i) ) dist++;
            }

            return dist;
        }
}

/*



Approximate Pattern Matching Problem: Find all approximate occurrences of a pattern in a string.
     Input: Strings Pattern and Text along with an integer d.
     Output: All starting positions where Pattern appears as a substring of Text with at most d mismatches.

Code Challenge: Solve the Approximate Pattern Matching Problem.

Return to Main Text

Sample Input:

ATTCTGGA
CGCCCGAATCCAGAACGCATTCCCATATTTCGGGACCACTGGCCTCCACGGTACGGACGTCAATCAAAT
3

Sample Output:

6 7 26 27




*/