class Solution {
    int count = 0;
    public int closedIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];             for(int i = 1; i < grid.length ; i++)
        {
            for(int j = 1; j < grid[i].length ; j++)
            {
                if(grid[i][j] == 0 && !visited[i][j])
                {
                   if(dfs(grid,i,j,visited)) count++;
                }
            }
        }
        return count;
    }
    
    public boolean dfs(int[][] grid, int i, int j, boolean[][] visited)
    {
        if(i==0||j==0||i==grid.length-1||j==grid[0].length-1)
            return false;
        
        if(visited[i][j]) return true;
        
        boolean up = true, down = true, left = true, right = true;
        if(grid[i][j] == 0 && !visited[i][j])
        {
            visited[i][j] = true;
    
            if(grid[i-1][j] == 1) up = true;
            else if(i-1 == 0) up = false;
            else up = up & dfs(grid,i-1,j,visited);
             
            if(grid[i+1][j] == 1) down = true;
            else if(i+1 == grid.length-1) down = false;
            else down = down & dfs(grid,i+1,j,visited);
             
            if(grid[i][j-1] == 1) left = true;
            else if(j-1 == 0) left = false; 
            else left = left & dfs(grid,i,j-1,visited);
             
            if(grid[i][j+1] == 1) right = true;
            else if(j+1 == grid[0].length-1) right = false; 
            else right = right & dfs(grid,i,j+1,visited);
        }
        return up && down && left && right;
    }
}
