public static List<String> FrequentWordsWithMismatches(String text, int k, int d) {
    List<String> ret = frqWordMismatch(text, k, d);
    
    return ret;
}

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

public static ArrayList<String> frqWordMismatch(String Genome, int k, int d)
    {//k - k-mer length | d - # of mistatches
        ArrayList<String> frqPtn = new ArrayList<String>();
        ArrayList<String> nborhood = new ArrayList<String>();
        ArrayList<String> localNeighbr;

        for(int i=0; i<=(Genome.length() - k); i++)
        {
            localNeighbr = findNeighbors(Genome.substring(i, i+k), d);
            nborhood.addAll(localNeighbr);
        }


        String ptn;
        int num;
        int[] indexes = new int[nborhood.size()];
        int[] count = new int[nborhood.size()];
        for(int i=0; i<nborhood.size(); i++)
        {
            ptn = nborhood.get(i);
            num = ptnToNum(ptn);
            indexes[i] = num;
            count[i] = 1;
        }

        indexes = doInsertionSort(indexes);

        for(int i=0; i<nborhood.size()-1; i++)
        {
            if(indexes[i] == indexes[i+1]) count[i+1] = count[i] + 1;
        }

        int max = Integer.MIN_VALUE;
        for(int i=0; i<count.length; i++) if(count[i]>max) max = count[i];

        for(int i=0; i<nborhood.size(); i++)
        {
            if(count[i] == max)
            {
                ptn = numToPtn(indexes[i], k);
                if( frqPtn.contains(ptn) ) continue;
                frqPtn.add(ptn);
            }
        }

        return frqPtn;
    }



public static int[] doInsertionSort(int[] input){
         
        int temp;
        for (int i = 1; i < input.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(input[j] < input[j-1]){
                    temp = input[j];
                    input[j] = input[j-1];
                    input[j-1] = temp;
                }
            }
        }
        return input;
    }















public static int ptnToNum(String str)
    {
        return toNum(str);
    }

    //under the hood with recursion
    private static int toNum(String str)
    {
        int len = str.length();
        char symb;
        String prefix;
        int ret;

        if(len == 0) return 0;

        symb = str.charAt(len-1);

        prefix = str.substring(0, len-1);

        ret = 4*toNum(prefix) + symToNum(symb);

        return ret;
    }

    /* ********************************************* */

    //public numToptn conversion
    public static String numToPtn(int index, int k)
    {
        return toPtn(index, k);
    }

    //under the hood fnx with recursion
    private static String toPtn(int num, int len)
    {
        if(len == 1) return numToSym(num);
        int prefixNum, symNum;
        String sym, prefix;

        //get the quotient and remainder
        prefixNum = num / 4;
        symNum = num % 4;

        sym = numToSym(symNum);
        prefix = toPtn(prefixNum, len-1);

        return prefix + sym;
    }



    

    /* ****************************** */

    //symbol to number alphabetically
    private static int symToNum(char c)
    {
        if(c == 'A') return 0;

        if(c == 'C') return 1;

        if(c == 'G') return 2;

        if(c == 'T') return 3;

        return -1;
    }
    
    //final step in to convert modulus to nucleotide
    private static String numToSym(int n)
    {
        if(n == 0) return "A";

        if(n == 1) return "C";

        if(n == 2) return "G";

        if(n == 3) return "T";

        return null;
    }















    public static ArrayList<String> findNeighbors(String ptn, int d)
    {
        String A = "A";
        String C = "C";
        String G = "G";
        String T = "T";

        String[] Nucleotides = {A, C, G, T};
        
        
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
            if ( findHammingDist(suffix, suffixNeibor) < d )
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