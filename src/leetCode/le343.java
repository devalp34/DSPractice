class Solution {
    public int integerBreak(int n) {
        if(n == 2) return 1;
        if(n == 3) return 2;
        
        int[][] dp = new int[n][n+1];
        int ans = 1;
        
        for(int i = 0 ; i < dp[0].length ; i++) dp[0][i] = 1;
        for(int i = 0 ; i < dp.length ; i++) dp[i][0] = 1;
        
        for(int i = 1 ; i < dp.length ; i++)
        {
            int row = i+1;
            for(int j = 1 ; j < dp[0].length ; j++)
            {
                int col = j;
                if(col < row) dp[i][col] = dp[i-1][j];
                else 
                dp[i][col] = Math.max(dp[i][col-row] * row,dp[i-1][col]);
            }
            ans = Math.max(ans,dp[i][dp[0].length-1]);
        }
        return ans;
    }
}
