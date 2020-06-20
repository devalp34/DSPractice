class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 0) return 0;
        int len = nums.length, mul = 0, max = 0, min = 0, temp = 0;
        
        mul = min = max = nums[0];
        
        for(int i = 1 ; i < len ; i++)
        {
            temp = min;
            min = Math.min(nums[i], Math.min(min * nums[i] , max * nums[i]));
            max = Math.max(nums[i], Math.max(temp * nums[i] , max * nums[i]));
            mul = Math.max(mul,Math.max(min,max));
        }
        return mul;
    }
}
