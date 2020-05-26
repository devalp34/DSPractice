class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        unionFind uf = new unionFind(s.length());
        
        for(List<Integer> l : pairs)
            uf.union(l.get(0),l.get(1));
        
        Map<Integer, PriorityQueue<Character>> pqMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int p = uf.getRoot(i);
            PriorityQueue pq = pqMap.get(p);
            if (pq==null){
                pq = new PriorityQueue<>();
                pqMap.put(p, pq);
            }
            pq.offer(s.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = pqMap.get(uf.getRoot(i)).poll();
            sb.append(ch);
        }
        return sb.toString();
    }
    
    class unionFind
    {
        int[] p;
        int[] r;
        int ds;
        public unionFind(int n)
        {
            p = new int[n];
            r = new int[n];
            for(int i = 0 ; i < n ; i++) p[i] = i;
            ds = n;
        }
        
        void union(int i, int j)
        {
            int pi = getRoot(i);
            int pj = getRoot(j);
            if(r[pi] > r[pj]){
                p[pj] = pi;
                r[pi]++;
            }else{
                p[pi] = pj;
                r[pj]++;
            }
            ds--;
        }
        
        int getRoot(int i)
        {
            while(i != p[i]) i = p[i];
            return i;
        }
    }
}
