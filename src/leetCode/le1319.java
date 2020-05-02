class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1) return -1;
        dfs s = new dfs(n);
        HashSet<Integer> hs = new HashSet<>();
        for(int[] a : connections) s.union(a[0],a[1]);
        for(int[] a : connections) hs.add(s.find(a[0]));
        return hs.size() - 1 + s.cal();
    }
    
    class dfs
    {
        int[] c;
        int ptr = 0;
        
        public dfs(int n)
        {
            c = new int[n];
            Arrays.fill(c,-1);
        }
        
        public void union(int a, int b)
        {
            int d = find(a);
            int e = find(b);
            c[d] = e;
            if(c[e] == -1) c[e] = e;
        }
        
        public int find(int i)
        {
            if(c[i] != -1 && c[i] !=i) find(c[i]);
            else ptr = i;
            return ptr;
        }
        
        public int cal()
        {
            int count = 0;
            for(int i : c)
            {
                if(i == -1) count++;
            }
            return count;
        }
    }
}
