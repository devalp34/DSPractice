class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        int rows = matrix.length;
        if(rows == 0) return new int[0];
        
        int cols = matrix[0].length;
        if(rows == 1)
        {
            int[] ans = new int[cols];
            int ptr = 0;
            for(int i : matrix[0]) ans[ptr++] = i;
            return ans;
        }
        
        if(cols == 1) 
        {
            int[] ans = new int[rows];
            int ptr = 0;
            for(int i = 0 ; i < rows ; i++) ans[ptr++] = matrix[i][0];
            return ans;
        }
        
        int[] ans = new int[rows * cols];
        int ptr = 0, row = 0, col = 0;
        boolean complete = true, up = true, down = false;
        
        while(ptr < rows * cols)
        {
            ans[ptr++] = matrix[row][col];
            if(up)
            {
                if(row > 0 && col < cols - 1)
                {
                    row--;
                    col++;
                }
                else
                {
                    up = !up;
                    down = !down;
                    if(col < cols - 1) col++;
                    else row++;
                }
            }
            else 
            {
                if(col > 0 && row < rows - 1)
                {
                    row++;
                    col--;
                }
                else
                {
                    down = !down;
                    up = !up;
                    if(row < rows - 1) row++;
                    else col++;
                }
            }
        }
        return ans;
    }
}
