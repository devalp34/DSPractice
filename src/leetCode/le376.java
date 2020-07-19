class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length <= 1) return nums.length;
        
        int len = nums.length, diff = 0, tempDiff = 0, ans = 1;
        int[] dp = new int[len];
        Arrays.fill(dp,1);
        boolean flag = false;
        
        for(int i = 1 ; i < len ; i++)
        {
            tempDiff = nums[i-1] - nums[i];
            
            if(tempDiff == 0)
            {
                dp[i] = dp[i-1];
                continue;
            }
            
            if(flag)
            {
                if(diff > 0 && tempDiff < 0) dp[i] = dp[i-1] + 1; 
                else if(diff < 0 && tempDiff > 0) dp[i] = dp[i-1] + 1;
                else dp[i] = dp[i-1];
            }
            else
            {
                dp[i] = dp[i-1] + 1;
                flag = true;
            }
            
            diff = tempDiff;
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
