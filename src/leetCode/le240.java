class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        if(rows == 0) return false;
        
        int cols = matrix[0].length, start = 0, end = 0;
        
        while(start < cols && start < rows && matrix[start][start] <= target)
        {
            if(matrix[start][start] > target) break;
            if(matrix[start][cols-1] >= target)
            {
                for(int i = start ; i < cols ; i++)
                    if(matrix[start][i] == target) 
                        return true;
            }
            if(matrix[rows-1][start] >= target)
            {
                for(int i = start ; i < rows ; i++)
                    if(matrix[i][start] == target) 
                        return true;
            }
            start++;
        }
        return false;
    }
}
