import java.util.ArrayList;
import java.util.HashSet;

public class Neighborhood {
    public static final String A = "A";
    public static final String C = "C";
    public static final String G = "G";
    public static final String T = "T";

    final static String[] Nucleotides = {A, C, G, T};

    public static ArrayList<String> findNeighbors(String ptn, int d)
    {
        String suffix, ptrnPrime;

        ArrayList<String> suffNeiAL = new ArrayList<String>();
        ArrayList<String> retArList = new ArrayList<String>();

        if( d == 0)
        {
            retArList.add(ptn);
            return retArList;
        }
        
        if ( ptn.length() == 1 )
        {
            retArList.add(A);
            retArList.add(C);
            retArList.add(G);
            retArList.add(T);

            return retArList;
        }

        suffix = ptn.substring(1);

        suffNeiAL = findNeighbors(suffix, d);

        for(String suffixNeibor : suffNeiAL)
        {
            if ( HammingDist.findHammingDist(suffix, suffixNeibor) < d )
            {
                for(String nucl : Nucleotides)
                {
                    ptrnPrime = nucl + suffixNeibor;
                    retArList.add(ptrnPrime);
                }
            }else
            {
                ptrnPrime = ptn.charAt(0) + suffixNeibor;
                retArList.add(ptrnPrime);
            }
        }

        return retArList;
    }
}

/*

    Neighbors(Pattern, d)
        if d = 0
            return {Pattern}
        if |Pattern| = 1 
            return {A, C, G, T}
        Neighborhood ← an empty set
        SuffixNeighbors ← Neighbors(Suffix(Pattern), d)
        for each string Text from SuffixNeighbors
            if HammingDistance(Suffix(Pattern), Text) < d
                for each nucleotide x
                    add x • Text to Neighborhood
            else
                add FirstSymbol(Pattern) • Text to Neighborhood
        return Neighborhood

*/