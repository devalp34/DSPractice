class Solution {
    Queue<Integer> q = new LinkedList<Integer>();
    HashSet<Integer> hs = new HashSet<Integer>();
    
    public int findCircleNum(int[][] M) {
        int count = 0;
        for(int i = 0 ; i < M.length ; i++)
        {
            for(int j = 0 ; j < M[0].length ; j++)
            {
                if(M[i][j] == 1 && !hs.contains(i) && !hs.contains(j))
                {
                    q.add(i);
                    q.add(j);
                    hs.add(i);
                    hs.add(j);
                    dfs(M);
                    count++;
                }
            }
        }
        return count;
    }
    
    void dfs(int[][] m)
    {
        while(q.size() > 0)
        {
            int i = q.poll();
            if(i < m.length)
            {
                for(int j = 0 ; j < m[0].length ; j++)
                {
                    if(m[i][j] == 1 && !hs.contains(j))
                    {
                        q.add(j);
                        hs.add(j);
                    }
                }    
            }
        }
        return;
    }
}
