class Solution {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) 
    {
        if(Profits.length != Capital.length || k == 0) return W;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((e1,e2) -> e2 - e1);
        HashSet<Integer> hs = new HashSet<>();
        
        int len = Capital.length;
        
        for(int i = 0 ; i < len ; i++)
        {
            if(Capital[i] <= W)
            {
                pq.add(Profits[i]);
                Capital[i] = -1;
            }
            else hs.add(i);
        }
        
        if(pq.isEmpty()) return W;
        List<Integer> l = new LinkedList<Integer>();
        
        while(k > 0 && !pq.isEmpty())
        {
            W += pq.poll();
            k--;
            if(k == 0) break;
            
            for(int i : hs)
            {
                if(Capital[i] <= W)
                {
                    pq.add(Profits[i]);
                    l.add(i);
                }   
            }
            
            for(int i : l) hs.remove(i);
            l.clear();
        }
        
        return W;
    }
}
