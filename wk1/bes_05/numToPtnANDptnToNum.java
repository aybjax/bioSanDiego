import java.util.ArrayList;

public class numToPtnANDptnToNum {
    //ptnToNumber conversion
    //public
    public static long ptnToNum(String str)
    {
        return toNum(str);
    }

    //under the hood with recursion
    private static long toNum(String str)
    {
        int len = str.length();
        char symb;
        String prefix;
        long ret;

        if(len == 0) return 0;

        symb = str.charAt(len-1);

        prefix = str.substring(0, len-1);

        ret = 4*toNum(prefix) + (long) symToNum(symb);

        return ret;
    }

    /* ********************************************* */

    //public numToptn conversion
    public static String numToPtn(long index, int k)
    {
        return toPtn(index, k);
    }

    //under the hood fnx with recursion
    private static String toPtn(long num, int len)
    {
        if(len == 1) return numToSym((int) num);
        long prefixNum, symNum;
        String sym, prefix;

        //get the quotient and remainder
        prefixNum = num / 4;
        symNum = num % 4;

        sym = numToSym((int) symNum);
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

    /* ********************************* */

//    public String numAsString()
//    {
//        return String.format("%d", index);
//    }
}



/*
PatternToNumber(Pattern)
        if Pattern contains no symbols
            return 0
        symbol ← LastSymbol(Pattern)
        Prefix ← Prefix(Pattern)
        return 4 · PatternToNumber(Prefix) + SymbolToNumber(symbol)


NumberToPattern(index, k)
        if k = 1
            return NumberToSymbol(index)
        prefixIndex ← Quotient(index, 4)
        r ← Remainder(index, 4)
        symbol ← NumberToSymbol(r)
        PrefixPattern ← NumberToPattern(prefixIndex, k − 1)
        return concatenation of PrefixPattern with symbol
*/