package leeeeeeee.dp;

/**
 * Created by jialihan on 17/10/22.
 */
public class RegularExpressMatching {
    public static void main(String[] args)
    {
        RegularExpressMatching instance = new RegularExpressMatching();
        String pattern = "ab*";
        String str = "ac";
        if ( instance.isMatch(str,pattern))
        {
            System.out.println(str+ " matches " + pattern);
        }
        else
        {
            System.out.println(str+ "  not matches " + pattern);
        }

    }
    public boolean isMatch(String ss, String pp) {

        char[] s = ss.toCharArray();
        char[] p = pp.toCharArray();
        boolean[][] dp = new boolean[s.length + 1][p.length + 1];
        // initialization like *a*b
        dp[0][0] = true;
        for (int j = 1; j < dp[0].length; j++) {
            if (p[j-1] == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        //
        for (int i = 1; i < dp.length; i++)
            for (int j = 1; j < dp[0].length; j++) {
                if (p[j - 1] == '.' || s[i - 1] == p[j - 1])
                    dp[i][j] = dp[i - 1][j - 1];
                else if (p[j - 1] == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (p[j - 2] == s[i - 1] || p[j - 2] == '.') {
                        dp[i][j] = dp[i][j] | dp[i - 1][j];
                    }
                } else
                    dp[i][j] = false;

            }

        return dp[s.length][p.length];
    }

    }
