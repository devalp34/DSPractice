class Solution {
    public boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        if(len <= 2) return false;
        
        int[] dp = new int[len];
        
        for(int i = 0 ; i < nums.length ; i++)
        {
            for(int j = 0 ; j < i ; j++)
            {
                if(nums[j] < nums[i])
                    dp[i] = Math.max(dp[i] , dp[j] + 1);
            }
            dp[i] = Math.max(dp[i],1);
            if(dp[i] == 3) return true;
        }
        return false;
    }
}
