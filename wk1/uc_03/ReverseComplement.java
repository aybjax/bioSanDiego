public class ReverseComplement
{
    public static String getComplementString(String sequence)
    {
        char tmp;
        String complementString = "";

        for(int i = sequence.length()-1; i>=0; i--)
        {
            tmp = sequence.charAt(i);
            switch(tmp)
            {
                case 'A': tmp = 'T'; break;
                case 'T': tmp = 'A'; break;
                case 'G': tmp = 'C'; break;
                case 'C': tmp = 'G'; break;
            }
            complementString += tmp;
        }

        return complementString;
    }
}