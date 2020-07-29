class Solution {
    public int totalHammingDistance(int[] nums) {
        int ans = 0, len = nums.length, count = 0;
        
        for(int i = 0 ; i < 32 ; i++)
        {
            for(int j : nums)
            {
                count += (j >> i) & 1;
            }
            ans += count * (len - count);
            count = 0;
        }
        
        return ans;
    }
}
