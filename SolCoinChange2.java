// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes

class SolCoinChange2 {
    public int change(int amount, int[] coins) {

        if(coins.length == 0 || coins == null) return 0;

        int m = coins.length;
        int n = amount;

        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 1;

        for(int i=1; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                if(j<coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }

        return dp[m][n];

    }
}