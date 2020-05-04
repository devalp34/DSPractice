class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int i = 0 , j = nums.length - 1, max = 0;
        if(nums[0] > nums[nums.length-1]) return nums.length;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        PriorityQueue<Integer> pq1 = new PriorityQueue<>((a,b) -> a-b);
        
        for(int k : nums)
        {
            pq.add(k);
            pq1.add(k);   
        }
        
        for(i = 0 ; i < nums.length-1 ; i++)
        {
            if(nums[i] > nums[i+1]) break;
            if(nums[i] == pq1.peek()) pq1.remove(nums[i]);
        }
        
        if(i == nums.length-1) return 0;
        
        for(j = nums.length-1 ; j > 0 ; j--)
        {
            if(nums[j] < nums[j-1]) break;
            if(nums[j] == pq.peek()) pq.remove(nums[j]);
        }
        
        while(i > -1 && nums[i] > nums[j]) i--;
        if(i == -1) i++;
        else if(nums[i] <= nums[j])
        {
            while(pq1.peek() < nums[i]) 
            {
                if(i == 0) break;
                i--;
            }
            if(nums[i] <= nums[i+1] && pq1.peek() >= nums[i])i++;
        }
        while(j < nums.length && pq.peek() > nums[j]) j++;
        if(j == nums.length || pq.peek() <= nums[j])j--;
        
        if(j-i > 0) return j-i+1;
        return 0;
    }
}
