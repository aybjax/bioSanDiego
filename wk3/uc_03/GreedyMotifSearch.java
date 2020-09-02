//xuynya

import java.util.ArrayList;
import java.util.List;

public class GreedyMotifSearch {
    List<String> findMotifMatrix(ArrayList<String> Dna, int k, int t)
    {
        ArrayList<String> bestMotifs = firstMotifMatrix(Dna, k, t);
        int bestScore = 0;
        String kmer = "";
        String score = 0;
        String firstString = Dna.get(0);

        String motif1 = "";
        String motif = "";
        ArrayList<String> profile = new ArrayList<>();

        for(int i = 0; i<= ( firstString.length() - k ); i++ )
        {
            kmer = firstString.substring(i, i+k);
            profile.add(kmer);
            for(int j = 1; j<t; j++)
            {
                kmer = Dna[0].substring
            }
        }
    }
}


/*

    GreedyMotifSearch(Dna, k, t)
        BestMotifs ← motif matrix formed by first k-mers in each string from Dna
        for each k-mer Motif in the first string from Dna
            Motif1 ← Motif
            for i = 2 to t
                form Profile from motifs Motif1, …, Motifi - 1
                Motifi ← Profile-most probable k-mer in the i-th string in Dna
            Motifs ← (Motif1, …, Motift)
            if Score(Motifs) < Score(BestMotifs)
                BestMotifs ← Motifs
        return BestMotifs

*/

/*

    GreedyMotifSearch(dna, k, t)
        bestMotifs = List()
        for each (strand in dna) {
            bestMotifs += strand.substring(0,k)
        }
      
        baseStrand = dna[0]
        otherStrands = dna[1 until t]
      
        for each (kmer in baseStrand)
            motifs = List(kmer)
            for each (strand in otherStrands)
                profileMatrix = createProfileMatrix(motifs)
                // note: profileMostProbableKmer ties are broken
                // by whichever motif appears earliest in strand
                nextMotif = profileMostProbableKmer(strand, k, profileMatrix)
                motifs += nextMotif
            if Score(motifs) < Score(bestMotifs)
                bestMotifs = motifs
        output bestMotifs

*/

/*

    GreedyMotifSearch(k,t,Dna)
        bestMotifs ← empty list (score of 0)
        for i from 0 to |Dna[0]| - k
            motifs ← list with only Dna[0](i,k)
            for j from 1 to |Dna| -1
                Add ProfileMostProbableKmer(Dna[j],k,Profile(motifs)) to motifs
            if score(motifs) < score(bestMotifs)
                bestMotifs = motifs
        return bestMotifs

*/