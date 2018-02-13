package leeeeeeee.dp;

import java.util.Comparator;
import java.util.TreeMap;

public class DecodeWays {

    // dp Space is O(n)
    public int numDecodings(String s) {
        if(s==null || s.length()==0) {
            return 0;
        }
        if(s.charAt(0)=='0') {
            return 0;
        }

        int [] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=s.length();i++) {
            //检查当前字符是不是'0'
            if(s.charAt(i-1)!='0')
                dp[i] += dp[i-1];
            //检查当前字符和前一个字符组合在一起是否在1-26之间
            if(s.charAt(i-2) == '1' || (s.charAt(i-2) == '2' && s.charAt(i-1) <= '6'))
                dp[i] += dp[i-2];
        }
        return dp[s.length()];
    }

    // 改写： Space is O(1)的方法
//    我们再来看一种空间复杂度为O(1)的解法，我们用两个变量c1, c2来分别表示s[i-1]和s[i-2]的解码方法，
//    然后我们从i=1开始遍历，也就是字符串的第二个字符，我们判断如果当前字符为'0'，说明当前字符不能单独拆分出来，
//    只能和前一个字符一起，我们先将c1赋为0，然后我们看前面的字符，如果前面的字符是1或者2时，
//    我们就可以更新c1 = c1 + c2，然后c2 = c1 - c2，其实c2赋值为之前的c1，
//    如果不满足这些条件的话，那么c2 = c1，参见代码如下：


    public int numDecodings2(String s) {

        if (s==null || s.length()==0 || s.charAt(0) == '0')
            return 0;

        int c1 = 1, c2 = 1;
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == '0') c1 = 0;
            if (s.charAt(i - 1) == '1' || (s.charAt(i - 1)  == '2' && s.charAt(i) -'0' <= 6)) {
                c1 = c1 + c2;
                c2 = c1 - c2;
            } else {
                c2 = c1;
            }
        }
        return c1;
    }


}
