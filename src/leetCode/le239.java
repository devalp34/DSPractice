class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length, start = 0;
        int[] ans = new int[len - k + 1];        
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int i = 0 ; i < len ; i++)
        {
            if(i >= k)
            {
                ans[start] = pq.peek();
                hm.put(nums[start],hm.get(nums[start])-1);
                if(nums[start] == pq.peek()) 
                {
                    while(pq.size() > 0 && hm.get(pq.peek()) == 0) pq.poll();
                }
                start++;
            }
            pq.add(nums[i]);
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        
        ans[len - k] = pq.peek();
        return ans;
    }
}
