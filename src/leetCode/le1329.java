class Solution {
    public int[][] diagonalSort(int[][] mat) 
    {
        int rows = mat.length, j = 0, k = 0;
        int cols = mat[0].length;
        int opn = Math.min(rows,cols);
        List<Integer> l = new LinkedList<Integer>();
        
        while(j < cols)
        {
            k = j;
            for(int i = 0 ; i < opn ; i++)
            {
                if(k == cols) break;
                l.add(mat[i][k]);
                k++;
            }
            Collections.sort(l);
            int ptr = 0;
            k = j;
            for(int i = 0 ; i < opn ; i++)
            {
                if(k == cols) break;
                mat[i][k] = l.get(ptr++);
                k++;
            }
            l.clear();
            j++;
        }
        
        j = 1;
        while(j < rows)
        {
            k = j;
            for(int i = 0 ; i < opn ; i++)
            {
                if(k == rows) break;
                l.add(mat[k][i]);
                k++;
            }
            Collections.sort(l);
            int ptr = 0;
            k = j;
            for(int i = 0 ; i < opn ; i++)
            {
                if(k == rows) break;
                mat[k][i] = l.get(ptr++);
                k++;
            }
            l.clear();
            j++;
        }
        return mat;
    }
}
