class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int len = nums.length;
        if(len == 0) return true;
        
        int[][] sum = new int[len][len];
        int[][] dp = new int[len][len];
        int temp = 0;
        
        for(int i = 0 ; i < len ; i++)
        {
            for(int j = i ; j < len ; j++)
            {
                temp += nums[j];
                sum[i][j] = temp;
            }
            temp = 0;
        }
        
        int sp = 0, ep = 0, spIndex = 0, epIndex = 0;
        
        for(int length = 1 ; length <= len ; length++)
        {
            for(int i = 0 ; i <= len - length ; i++)
            {
                if(length == 1) dp[i][i] = nums[i];
                else
                {
                    spIndex = i;
                    epIndex = i + length - 1;
                    sp = nums[spIndex];
                    ep = nums[epIndex];
                    
                    dp[spIndex][epIndex] = Math.max(sp+sum[spIndex+1][epIndex]-dp[spIndex+1][epIndex], ep+sum[spIndex][epIndex-1]-dp[spIndex][epIndex-1]);
                }
                
            }
        }
        return (sum[0][len-1] - dp[0][len-1]) <= dp[0][len-1];
    }
}
