class Solution {
    int r = 0;
    public List<Integer> luckyNumbers (int[][] matrix) {
        r = matrix.length;
        List<Integer> ans = new LinkedList<Integer>();
        for(int i = 0 ; i < r ; i++)
        {
            int index = 0, num = Integer.MAX_VALUE;
            for(int j = 0 ; j < matrix[i].length ; j++)
            {
                if(num > matrix[i][j])
                {
                    num = matrix[i][j];
                    index = j;
                }
            }
            if(findMax(index,matrix,num)) ans.add(num); 
        }
        return ans;
    }
    
    public boolean findMax(int index, int[][] m, int target)
    {
        for(int i = 0 ; i < r ; i++) 
        {
            if(target < m[i][index]) return false;
        }
        return true;
    }
}
