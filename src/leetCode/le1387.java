class Solution {
    public int getKth(int lo, int hi, int k) {
        HashMap<Integer,PriorityQueue<Integer>> pqMap = new HashMap<>();
        List<Integer> l = new LinkedList<Integer>();
        HashMap<Integer,Integer> hm = new HashMap<>();
        int ptr = 0;
        
        for(int j = lo ; j <= hi ; j++)
        {
            int i = j;
            ptr = 0;
            while(i != 1)
            {
                if(hm.containsKey(i))
                {
                    ptr += hm.get(i);
                    break;
                }
                if(i % 2 == 0) i /= 2;
                else i = (i * 3) + 1;
                ptr++;
            }
            hm.put(j,ptr);
            if(!pqMap.containsKey(ptr))l.add(ptr);
            pqMap.computeIfAbsent(ptr,m -> new PriorityQueue<Integer>());
            pqMap.get(ptr).add(j);
        }
        
        Collections.sort(l);
        int[] a = new int[hi-lo+1];
        ptr = 0;
        
        for(int i : l)
        {
            PriorityQueue<Integer> pq = pqMap.get(i);
            while(pq.size() != 0)
            {
                a[ptr++] = pq.poll();    
            }
        }
        
        return a[k-1];
    }
}
