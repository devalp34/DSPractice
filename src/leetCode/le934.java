class Solution {
    public int shortestBridge(int[][] A) {
        List<List<Integer>> first = new LinkedList<List<Integer>>();
        List<List<Integer>> second = new LinkedList<List<Integer>>();
        
        int colLen = A.length, rowLen = A[0].length;
        boolean[][] v = new boolean[colLen][rowLen];
        
        for(int i = 0 ; i < colLen ; i++)
        {
            for(int j = 0 ; j < rowLen ; j++)
            {
                if(A[i][j] == 1 && !v[i][j])
                {
                    if(first.size() == 0)
                        dfs(i,j,A,first,v,colLen,rowLen);
                    else dfs(i,j,A,second,v,colLen,rowLen);
                }
            }
        }
        
        int ans = Integer.MAX_VALUE;
        
        for(List<Integer> l1 : first)
        {
            for(List<Integer> l2 : second)
            {
                ans = Math.min(ans,(Math.abs(l1.get(0) - l2.get(0)) + Math.abs(l1.get(1) - l2.get(1)) - 1));
            }
        }
        
        return ans;
    }
    
    void dfs(int i, int j, int[][] a, List<List<Integer>> l, boolean[][] v, int cl, int rl)
    {
        if(i < 0 || j < 0 || i >= cl || j >= rl || a[i][j] == 0 || v[i][j])
            return;
        
        l.add(Arrays.asList(i,j));
        v[i][j] = true;
        
        dfs(i+1,j,a,l,v,cl,rl);
        dfs(i-1,j,a,l,v,cl,rl);
        dfs(i,j+1,a,l,v,cl,rl);
        dfs(i,j-1,a,l,v,cl,rl);
    }
}
