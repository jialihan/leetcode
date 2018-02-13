package leeeeeeee.dp;

/**
 * Created by jialihan on 17/6/29.
 */
//Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.
//
//        However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you guess the number I picked.
//
//        Example:
//
//        n = 10, I pick 8.
//
//        First round:  You guess 5, I tell you that it's higher. You pay $5.
//        Second round: You guess 7, I tell you that it's higher. You pay $7.
//        Third round:  You guess 9, I tell you that it's lower. You pay $9.
//
//        Game over. 8 is the number I picked.
//
//        You end up paying $5 + $7 + $9 = $21.
//        Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.


public class GuessNumberHighOrLowII {

        public int getMoneyAmount(int n) {
            int[][] dp = new int[n+1][n+1]; // 全部为0
            for (int L = n - 1; L > 0; L--) {  //为什么是从n-1开始呢？因为在递推关系式中用到了公式下面一行的数据，所以只能从n-1开始
                for (int R = L + 1; R <= n; R++) {//为什么从左开始呢？同样的道理
                    dp[L][R] = Integer.MAX_VALUE; //0x7FFFFFFF; //INT_MAX
                    for (int i = L; i < R; i++) {
                        dp[L][R] = Math.min(dp[L][R], i + Math.max(dp[L][i - 1], dp[i + 1][R]));
                    }
                }
            }
            return dp[1][n];

        }

    /**
     * dp[i][i] = 0;  只猜一个数字，必然win, 所以 money = 0 ;
     * dp[i][i+1]  = i;  猜2个数字，必然猜测小的一个，worst case: i猜错了， i+1必然对； money = i, 必win
     * Dp[i][j]表示在[i,j]范围内保证能赢的钱数。在[1, n]的范围中，我取一个数k，这样就被分为了[1, k-1], [k],[k+1, n]这三段。
     * 由于事先并不知道target坐落在哪个范围，既然要保证能赢，那么取Max(dp[1, k-1], dp[k, k], dp[k+1, n])。
     * 然后在众多k中选取cost最小的。
     */
}
