public class GetOriFromSkewDiagram {
    public static String getMinimun(String Genome)
    {
        int[] skewDiagram = SkewArray.plotSkewArray(Genome);

        int min = Integer.MAX_VALUE;
        for(int i=0; i<skewDiagram.length; i++)
        {
            if( min > skewDiagram[i] ) min = skewDiagram[i];
        }

        String ret="";
        boolean added = false;

        for(int i=0; i<skewDiagram.length; i++)
        {
            if(min != skewDiagram[i]) continue;

            if(added == false)
            {
                added = true;
                ret += i;
            }else if(added == true)
            {
                ret += " " + i;
            }
        }

        return ret;
    }
}