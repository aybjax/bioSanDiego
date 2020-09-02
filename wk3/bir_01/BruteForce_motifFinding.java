import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * BruteForce_motifFinding
 */
public class BruteForce_motifFinding {
    public static List<String> motifEnumeration(List<String> Dna, int k, int d)
    {
        Set<String> Ptns = new HashSet<>();
        ArrayList<String> neighbors;

        int seqCount = Dna.size();
        int count, dist;
        String firstSeq, otherSeq, otherSeqPtn, ptn;
        firstSeq = Dna.get(0);
        for(int i=0; i<= (firstSeq.length() - k); i++)
        {
            ptn = firstSeq.substring(i, i+k);
            neighbors = Neighborhood.findNeighbors(ptn, d);
            for(String neighbor : neighbors)
            {
                count = 1;
                for(int otherSeqNum=1; otherSeqNum<Dna.size(); otherSeqNum++)
                {
                    otherSeq = Dna.get(otherSeqNum);
                    for(int j=0; j<= (otherSeq.length() - k); j++)
                    {
                        otherSeqPtn = otherSeq.substring(j, j+k);
                        dist = HammingDist.findHammingDist(neighbor, otherSeqPtn);
                        if(dist <= d)
                        {
                            count++;
                            break;
                        }
                    }
                }
                if( count == seqCount ) Ptns.add(neighbor);
            }
        }
        return new ArrayList<>(Ptns);
    }
}


/*

    MotifEnumeration(Dna, k, d)
        Patterns ← an empty set
        for each k-mer Pattern in the first string in Dna
            for each k-mer Pattern’ differing from Pattern by at most d mismatches
                if Pattern' appears in each string from Dna with at most d mismatches
                    add Pattern' to Patterns
        remove duplicates from Patterns
        return Patterns

*/