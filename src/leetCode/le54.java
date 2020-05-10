class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length == 0) return new LinkedList<Integer>();
        boolean[][] v = new boolean[matrix.length+2][matrix[0].length+2];
        int rows = matrix.length, cols = matrix[0].length;
        
        for(int i = 0 ; i <= cols+1 ; i++) v[0][i] = v[rows+1][i] = true;
        for(int i = 0 ; i <= rows+1 ; i++) v[i][0] = v[i][cols+1] = true;
        
        List<Integer> l = new LinkedList<Integer>();
        int i = 1,j = 1;
        boolean left = false,right = false,up = false,down = false;
        
        if(cols > 1) left = true;
        else up = true;
        
        while(l.size() < rows*cols)
        {
            l.add(matrix[i-1][j-1]);
            if(l.size() == (rows * cols)) return l;
            v[i][j] = true;
            if(left)
            {
                if(!v[i][j+1]) j++;
                else if(!v[i+1][j])
                {
                    left = false;
                    i++;
                    up = true;
                }
                else break;
            }
            else if(up)
            {
                if(!v[i+1][j]) i++;
                else if(!v[i][j-1])
                {
                    up = false;
                    j--;
                    right = true;
                }
                else break;
            }
            else if(right)
            {
                if(!v[i][j-1]) j--;
                else if(!v[i-1][j])
                {
                    right = false;
                    i--;
                    down = true;
                }
                else break;
            }
            else
            {
                if(!v[i-1][j]) i--;
                else if(!v[i][j+1])
                {
                    down = false;
                    j++;
                    left = true;
                }
                else break;
            }
        }
        return l;
    }
}
