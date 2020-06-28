class NumMatrix {
    int[][] m;
    
    public NumMatrix(int[][] matrix) {
        int rows = matrix.length;
        if(rows == 0) return;
        
        int cols = matrix[0].length;
        
        m = new int[rows][cols];
    
        int sum = 0;
        
        for(int i = 0 ; i < rows ; i++)
        {
            sum = 0;
            for(int j = 0 ; j < cols ; j++)
            {
                sum += matrix[i][j];
                m[i][j] = sum;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans = 0;
        
        if(col1 == 0)
        {
            for(int i = row1 ; i <= row2 ; i++)
                ans += m[i][col2];
        }
        else
        {
            for(int i = row1 ; i <= row2 ; i++)
                ans += m[i][col2] - m[i][col1 - 1];
        }
        
        return ans;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
