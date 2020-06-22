class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int sum = 0, temp = 0, low = 1;
        int high = Integer.MIN_VALUE, mid = 0;
        
        for(int i : nums) high = Math.max(i,high);
        
        while(low < high)
        {
            mid = (low + high) / 2;
            
            for(int i : nums)
            {
                if(i % mid == 0) temp += (i / mid);
                else temp += (i/mid)+1; 
            }
            
            if(temp > threshold) low = mid+1;
            else high = mid;
            temp = 0;
        }
        return low;
    }
}
