package leeeeeeee.dp;

import java.util.Stack;

public class LongestValidParentheses {

    /**
     *复杂度 :  时间 O(N) 空间 O(N)
     思路:  动态规划法将大问题化为小问题，我们不一定要一下子计算出整个字符串中最长括号对，
            我们可以先从后向前，一点一点计算。假设d[i]是从下标i开始到字符串结尾最长括号对长度，
            s[i]是字符串下标为i的括号。如果s[i-1]是左括号，如果i + d[i] + 1是右括号的话，那d[i-1] = d[i] + 1。
           如果不是则为0。如果s[i-1]是右括号，因为不可能有右括号开头的括号对，所以d[i-1] = 0。
     */
    public static int longestValidParentheses(String s) {
         if(s == null || s.length() == 0)
              return 0;

         int[] dp = new int[s.length()];
         int maxLen = 0;
         for(int i = s.length()-2; i>=0; i--)
         {
             if(s.charAt(i) == '(')
             {
                 int end = i+dp[i+1]+1;
                 if(end<s.length() && s.charAt(end) == ')')
                 {
                     dp[i]  = dp[i+1]+2;
                     if(end +1 < s.length())
                     {
                         dp[i] += dp[end+1];
                     }
                 }
             }
             //
             maxLen = Math.max(maxLen, dp[i]);
         }

         return maxLen;
 }



    /**
     *  Use stack
     * @param s
     * @return
     */
    public static int longestValidParentheses3(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int start = 0;
        int maxLen  = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i< s.length();i++)
        {
            char c = s.charAt(i);
            if(c == '(')
            {
                stack.push(i);
            }
            else
            {
                if(stack.empty())
                {
                    // current i not valid, the next index is i+1
                    start = i+1;
                }
                else
                {
                   stack.pop();
                   if(stack.empty())
                   {
                       // from 0  to i is all valid
                       maxLen = Math.max(maxLen, i+1);
                   }
                   else
                   {
                       // compare the partion max len
                       maxLen = Math.max(maxLen, i-stack.peek());
                   }
                }
            }
        }
        return maxLen;

    }

}
