class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        if(len == 0) return new LinkedList<Integer>();
        
        int[] dp = new int[len];
        int[] index = new int[len];
        
        dp[0] = 1;
        index[0] = -1;
        
        int a = 0, b = 0, maxLen = 1, finIndex = 0;
        
        for(int i = 1 ; i < len ; i++)
        {
            a = nums[i];
            for(int j = 0 ; j < i ; j++)
            {
                b = nums[j];
                if(a % b == 0)
                {
                    if(dp[i] < dp[j] + 1) 
                    {
                        dp[i] = dp[j] + 1;
                        index[i] = j;
                    }
                }
            }
            
            if(dp[i] == 0)
            {
                dp[i] = 1;
                index[i] = -1;
            }
            
            if(maxLen < dp[i]) 
            {
                maxLen = dp[i];
                finIndex = i;
            }
        }
        
        List<Integer> ans = new LinkedList<Integer>();
        
        while(finIndex != -1)
        {
            ans.add(nums[finIndex]);
            finIndex = index[finIndex];
        }
        
        return ans;
    }
}
