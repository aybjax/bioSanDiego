public class FrqArray {

    public static int[] computeFrqArray(String Txt, int k)
    {
        String ptn;
        int indexOfPtn;

        int sizeOfFrqArr = (int) Math.pow(4, k);
        //frequency array of alphabetically sorted k-mers
        int[] frqAr = new int[sizeOfFrqArr];

        for(int i=0; i<sizeOfFrqArr; i++) frqAr[i] = 0;

        //loop though text and count frq of k-mers
        for(int i = 0; i <= (Txt.length() - k); i++ )
        {
            ptn = Txt.substring(i, i + k);
            indexOfPtn = (int) numToPtnANDptnToNum.ptnToNum(ptn);
            frqAr[indexOfPtn] = frqAr[indexOfPtn] + 1;
        }

        return frqAr;
    }

}