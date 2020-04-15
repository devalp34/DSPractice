class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        int[][] temp = new int[3][3];
        int ptr = 0;
        
        for(int i = 0 ; i < 3 ; i++)
        {
            for(int j = 0 ; j < 3 ; j++) temp[i][j] = -1;
        }
        
        for(int[] q : queens)
        {
            if(q[0] == king[0] || q[1] == king[1])
            {
                if(q[0] == king[0]) // Same row
                {
                    if(q[1] < king[1])
                    {
                        if(temp[1][0] == -1) temp[1][0] = ptr;
                        else if(q[1] > queens[temp[1][0]][1])
                                temp[1][0] = ptr;
                    }
                    else
                    {
                        if(temp[1][2] == -1) temp[1][2] = ptr;
                        else if(q[1] < queens[temp[1][2]][1])
                                temp[1][2] = ptr;
                    }
                }
                else // Same column
                {
                    if(q[0] < king[0])
                    {
                        if(temp[0][1] == -1) temp[0][1] = ptr;
                        else if(q[0] > queens[temp[0][1]][0])
                                temp[0][1] = ptr;
                    }
                    else
                    {
                        if(temp[2][1] == -1) temp[2][1] = ptr;
                        else if(q[0] < queens[temp[2][1]][0])
                                temp[2][1] = ptr;
                    }
                }
            }
            else if(Math.abs(q[0]-king[0]) == Math.abs(q[1] - king[1])) // For Diagonal
            {
                if(q[0] < king[0] && q[1] < king[1]) //2 qua
                {
                    if(temp[0][0] == -1) temp[0][0] = ptr;
                    else if(q[0] > queens[temp[0][0]][0]) temp[0][0] = ptr;
                }
                else if(q[0] > king[0] && q[1] > king[1])// 4 qua
                {
                    if(temp[2][2] == -1) temp[2][2] = ptr;
                    else if(q[0] < queens[temp[2][2]][0]) temp[2][2] = ptr;
                }
                else if(q[0] < king[0] && q[1] > king[1])// 1 qua
                {
                    if(temp[0][2] == -1) temp[0][2] = ptr;
                    else if(q[0] > queens[temp[0][2]][0]) temp[0][2] = ptr;
                }
                else // 3 qua
                {
                    if(temp[2][0] == -1) temp[2][0] = ptr;
                    else if(q[0] < queens[temp[2][0]][0]) temp[2][0] = ptr;
                }
            }
            ptr++;
        }
        
        // Fill the value in List
        for(int i = 0 ; i < 3 ; i++)
        {
            for(int j = 0 ; j < 3 ; j++)
            {
                if(temp[i][j] != -1)
                {
                    int[] a = queens[temp[i][j]];
                    List<Integer> l = new LinkedList<Integer>();
                    l.add(a[0]);
                    l.add(a[1]);
                    ans.add(l);
                }
            }
        }
        return ans;
    }
}
