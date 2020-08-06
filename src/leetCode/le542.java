class Solution {
    int[][] ans;
    int[][] direction = {{0,1},{0,-1},{-1,0},{1,0}};
    public int[][] updateMatrix(int[][] matrix) {
        int colLen = matrix.length, rowLen = matrix[0].length;
        ans = new int[colLen][rowLen];
        
        for(int i = 0 ; i < colLen ; i++)
        {
            for(int j = 0 ; j < rowLen ; j++)
            {
                if(matrix[i][j] != 0)
                {
                    bfs(matrix,i,j);
                }
            }
        }
        
        return ans;
    }
    
    void bfs(int[][] m, int i, int j)
    {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        int size = 0, step = 1, colLen = m.length, rowLen = m[0].length;
        
        while(!q.isEmpty())
        {
            size = q.size();
            for(int k = 0 ; k < size ; k++)
            {
                int[] curr = q.poll();
                for(int[] d : direction)
                {
                    int newX = curr[0] + d[0];
                    int newY = curr[1] + d[1];
                    if(valid(newX,newY,colLen,rowLen))
                    {
                        if(m[newX][newY] == 0) 
                        {
                            ans[i][j] = step;
                            return;
                        }
                        q.add(new int[]{newX,newY});
                    }
                }
            }
            step++;
        }
    }
    
    boolean valid(int x, int y, int cl, int rl)
    {
        if(x < 0 || y < 0 || x >= cl || y >= rl) return false;
        return true;
    }
}
