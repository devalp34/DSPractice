class Solution {
    int count = 0;
    public int maxAreaOfIsland(int[][] grid) {
        if(grid.length == 0) return 0;
        int mc = 0;
        boolean[][] t = new boolean[grid.length][grid[0].length];
         
        for(int i = 0 ; i < grid.length ; i++)
        {
            for(int j = 0 ; j < grid[i].length ; j++)
            {
                if(grid[i][j] == 1 && !t[i][j])
                {
                    dfs(grid,i,j,t);
                    mc = Math.max(mc,count);
                    count = 0;
                }
            }
        }
        return mc;
    }
    
    public int dfs(int[][] grid,int i, int j,boolean[][] t)
    {
        if(i<0 || i>= grid.length || j<0 || j>=grid[0].length || t[i][j])
            return 0;
        
        if(grid[i][j] == 1 && !t[i][j])
        {
            t[i][j] = true;
            count++;
            dfs(grid,i+1,j,t);
            dfs(grid,i-1,j,t);
            dfs(grid,i,j+1,t);
            dfs(grid,i,j-1,t);
        }
        return 0;
    }
}
