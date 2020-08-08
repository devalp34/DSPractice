class Solution {
    int[][] directions = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,1},{1,-1},{-1,-1}};
    int colLen, rowLen;
    
    public int maxDistance(int[][] grid) {
        colLen = grid.length;
        rowLen = grid[0].length;
        int ans = Integer.MIN_VALUE, val = 0;       
        for(int i = 0 ; i < colLen ; i++)
        {
            for(int j = 0 ; j < rowLen ; j++)
            {
                if(grid[i][j] == 0)
                {
                    val = bfs(grid,i,j, new boolean[colLen][rowLen]);
                    if(val == -1) return -1;
                    ans = Math.max(ans,val);
                }
            }
        }
        if(ans == Integer.MIN_VALUE) return -1;
        return ans;
    }
    
    int bfs(int[][] g, int x, int y, boolean[][] v)
    {
        Queue<int[]> q = new LinkedList<>();
        
        boolean flag = false;
        int size = 0, val = Integer.MAX_VALUE;
        q.add(new int[] {x,y});
        v[x][y] = true;
        
        while(!q.isEmpty())
        {
            size = q.size();
            for(int i = 0 ; i < size ; i++)
            {
                int[] curr = q.poll();
                for(int[] d : directions)
                {
                    int newX = curr[0] + d[0];
                    int newY = curr[1] + d[1];
                    if(valid(newX,newY))
                    {
                        if(g[newX][newY] == 1)
                        {
                            flag = true;
                            val = Math.min(val, Math.abs(newX-x) + Math.abs(newY-y));
                        }
                        if(!v[newX][newY])
                        {
                            v[newX][newY] = true;
                            q.add(new int[]{newX,newY});
                        }
                    }
                }
            }
            if(flag) return val;
        }
        return -1;
    }
    
    boolean valid(int x,int y)
    {
        if(x < 0 || x >= colLen || y < 0 || y >= rowLen) return false;
        return true;
    }
}
