class Solution {
    public boolean canReach(int[] arr, int start) {
        List<Integer> index = new LinkedList<Integer>();
        HashSet<Integer> hs= new HashSet<>();
        
        index.add(start);
        hs.add(start);
        int val = 0, idx = 0, len = arr.length;
        
        while(index.size() != 0)
        {
            idx = index.get(0);
            val = arr[idx];
            
            if(val == 0) return true;
            if(idx + val < len)
            {
                if(arr[idx+val] == 0) return true;
                else if(!hs.contains(idx + val)) 
                {
                    index.add(idx + val);
                    hs.add(idx + val);   
                }
            }
            
            if(idx - val >= 0)
            {
                if(arr[idx - val] == 0) return true;
                else if(!hs.contains(idx - val))
                {
                    index.add(idx - val);
                    hs.add(idx + val);
                }
            }
            index.remove(0);
        }
        return false;
    }
}
