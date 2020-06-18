class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        
        int limit = (int) Math.sqrt(n) + 1;
        int[] square = new int[limit];
        
        for(int i = 1 ; i <= limit ; i++) square[i-1] = i*i;
        
        int i = 0, j = 0, quatent = 0, rem = 0, min = Integer.MAX_VALUE;
        
        for(i = 2 ; i <= n ; i++)
        {
            min = Integer.MAX_VALUE;
            for(j = 0 ; j < limit ; j++)
            {
                if(square[j] < i) 
                {
                    quatent = i / square[j];
                    rem = i % square[j];
                    min = Math.min(min, (dp[square[j]] * quatent) + dp[rem]);
                }
                else if(square[j] == i)
                {
                    min = 1;
                    break;
                }
            }
            dp[i] = min;
        }
        
        return dp[n];
    }
}
