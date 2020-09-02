import java.util.ArrayList;

public class ClumpFindingEnhanced {
    //t - treshold to qualify for frequent      //L - width of window
    public static ArrayList<String> findClumpViaWindows(String Genome, int k, int L, int t)
    {
        String fstPtn, lstPtn, ptn;
        int indexInFrqArr;
        ArrayList<String> frqPtnArList = new ArrayList<String>();

        int sizeOfFrqArr = (int) Math.pow(4, k);
        //arr of ptrn with freq >= t in any clump
        int[] freqInClumps = new int[sizeOfFrqArr];
        for(int i=0; i<sizeOfFrqArr; i++) freqInClumps[i] = 0;

        //get the seq of size L
        String windowSeq = Genome.substring(0, L);

        //get frequency array of window in genome of length L
        int[] frqAr = FrqArray.computeFrqArray(windowSeq, k);
        
        //find k-mers with freq >= t in the window clump
        for(int i=0; i<sizeOfFrqArr; i++)
        {
            if(frqAr[i] >= t)
            {
                freqInClumps[i]  = 1;
            }
        }

        //move window clump and change only flanking k-mers
        for(int i=1; i<= (Genome.length() - L); i++)
        {
            //System.out.println("Transition: " + (i-1) + "->" + i);
            //decrement k-mer value - k-mer's 1st letter is gone
            fstPtn = Genome.substring(i-1, i-1+k);
            indexInFrqArr = (int) numToPtnANDptnToNum.ptnToNum(fstPtn);
            frqAr[indexInFrqArr]--;

            //increment k-mer value - k-mer's last letter is just come
            lstPtn = Genome.substring(i+L-k, i+L);
            indexInFrqArr = (int) numToPtnANDptnToNum.ptnToNum(lstPtn);
            frqAr[indexInFrqArr] = frqAr[indexInFrqArr] + 1;

            //System.out.print("\t<-x- " + fstPtn);
            //System.out.println("\t" + lstPtn + "-->\n\n");

            //see if new frq is enough to be >= t
            if(frqAr[indexInFrqArr] >= t)
            {
                freqInClumps[indexInFrqArr]  = 1;
            }
        }

        //add frq ptrns to set
        for(int i=0; i<sizeOfFrqArr; i++)
        {
            if( freqInClumps[i] == 1 )
            {
                ptn = numToPtnANDptnToNum.numToPtn(i, k);
                frqPtnArList.add(ptn);
            }
        }


        return frqPtnArList;
    }
}