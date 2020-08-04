class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int colLen = grid.length, rowLen = grid[0].length;
        boolean[][] v = new boolean[colLen][rowLen];
        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
        int count = 0, complete = 0;
        
        for(int i = 0 ; i < colLen ; i++)
        {
            for(int j = 0 ; j < rowLen ; j++)
            {
                if(grid[i][j] == 2) 
                {
                    q.add(new int[]{i,j});
                    v[i][j] = true;
                    count++;
                    complete++;
                }
                else if(grid[i][j] == 1) count++;
            }
        }
        
        int step = 0, size = 0;
        boolean flag = false;
        
        while(!q.isEmpty())
        {
            size = q.size();
            for(int i = 0 ; i < size ; i++)
            {
                int[] t = q.poll();
                for(int[] d : dir)
                {
                    int newX = t[0] + d[0];
                    int newY = t[1] + d[1];
                    if(!valid(newX,newY,colLen,rowLen)) continue;
                    if(grid[newX][newY] == 1 && !v[newX][newY])
                    {
                        complete++;
                        flag = true;
                        q.add(new int[]{newX,newY});
                        v[newX][newY] = true;
                    }
                }
            }
            
            if(flag)
            {
                step++;
                flag = false;   
            }
        }
        
        if(complete == count) return step;
        else return -1;
    }
    
    boolean valid(int x, int y, int cl, int rl)
    {
        if(x >= cl || x < 0 || y >= rl || y < 0) return false;
        else return true;
    }
}
