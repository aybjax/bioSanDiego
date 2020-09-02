public class HammingDist {
    //they are the same length
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