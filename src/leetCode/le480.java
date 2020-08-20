class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        
        if(len == 0) return new double[0];
        
        PriorityQueue<Integer> max = new PriorityQueue<>((e1,e2) -> e2>e1?1 : -1);
        PriorityQueue<Integer> min = new PriorityQueue<>();
        
        HashMap<Integer,Integer> hm1 = new HashMap<>();
        HashMap<Integer,Integer> hm2 = new HashMap<>();
        
        double[] ans = new double[len - k + 1];
        int peek = 0;
        
        for(int i = 0 ; i < k ; i++)
        {
            max.add(nums[i]);
            hm1.put(nums[i],hm1.getOrDefault(nums[i],0)+1);
            
            peek = max.peek();
            hm1.put(peek,hm1.get(peek) - 1);
            if(hm1.get(peek) == 0) hm1.remove(peek);
            hm2.put(peek, hm2.getOrDefault(peek,0)+1);
            
            min.add(max.poll());
            
            if(max.size() < min.size())
            {
                peek = min.peek();
                hm2.put(peek, hm2.get(peek) - 1);
                if(hm2.get(peek) == 0) hm2.remove(peek);
                hm1.put(peek, hm1.getOrDefault(peek,0)+1);
                
                max.add(min.poll());
            }
        }
        
        int ptr = 0, anchr = 0;
        
        for(int i = k ; i < len ; i++)
        {
            if(k % 2 == 0)
                ans[ptr] = ((double)max.peek() + (double)min.peek()) / 2;
            else ans[ptr] = (double)max.peek();
            
            anchr = nums[ptr++];
            
            if(hm1.containsKey(anchr))
            {
                hm1.put(anchr,hm1.get(anchr) - 1);
                if(hm1.get(anchr) == 0) hm1.remove(anchr);
                max.remove(anchr);
            }
            else
            {
                hm2.put(anchr,hm2.get(anchr) - 1);
                if(hm2.get(anchr) == 0) hm2.remove(anchr);
                min.remove(anchr);
            }
            
            max.add(nums[i]);
            hm1.put(nums[i],hm1.getOrDefault(nums[i],0)+1);
            
            peek = max.peek();
            hm1.put(peek,hm1.get(peek) - 1);
            if(hm1.get(peek) == 0) hm1.remove(peek);
            hm2.put(peek, hm2.getOrDefault(peek,0)+1);
            
            min.add(max.poll());
            
            if(max.size() < min.size())
            {
                peek = min.peek();
                hm2.put(peek, hm2.get(peek) - 1);
                if(hm2.get(peek) == 0) hm2.remove(peek);
                hm1.put(peek, hm1.getOrDefault(peek,0)+1);

                max.add(min.poll());
            }
        }
        
            
        if(k % 2 == 0) 
            ans[ptr] = ((double)max.peek() + (double)min.peek()) / 2;
        else ans[ptr] = (double)max.peek();
        
        return ans;
    }
}
