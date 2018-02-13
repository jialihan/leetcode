package leeeeeeee.bitManipulation;

/**
 * Created by jialihan on 17/1/21.
 * Easy
 */
public class HammingDistance {

    public static void main(String[] args)
    {


        System.out.println(hammingDistance2(5, 1));

    }

    public static int hammingDistance(int x, int y) {
        String s1 = Integer.toBinaryString(x);
        String s2 = Integer.toBinaryString(y);
        int res = 0;
        String large = null;
        String small = null;
        int len1 = 0;
        int len2 = 0;
        if(s1.length()> s2.length())
        {
            large = s1;
            small = s2;
            len1 = s1.length();
            len2 = s2.length();
        }
        else
        {
            small = s1;
            large = s2;
            len1 = s2.length();
            len2 = s1.length();
        }
        int diff = len1-len2;
        if(len1-len2 >0 )
        {
            for(int i = 0; i<diff;i++)
            {
                if(large.charAt(i) == '1')
                    res += 1;
            }
        }
        for(int i =0; i<len2;i++)
        {
            if(small.charAt(i) != large.charAt(i+diff))
                res+=1;
        }
        System.out.println("x: " + Integer.toBinaryString(x));
        System.out.println("y: " + Integer.toBinaryString(y));

        return res;

    }

     public static int hammingDistance2(int x, int y) {
         System.out.println("x: " + Integer.toBinaryString(x));
         System.out.println("y: " + Integer.toBinaryString(y));

         return Integer.bitCount(x^y);
     }
}
