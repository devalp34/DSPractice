class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) 
    {
        List<List<Integer>> l1 = new LinkedList<List<Integer>>();
        int i = 0, j = 0;
        
        while(i < A.length && j < B.length)
        {
            if(A[i][1] < B[j][0]) 
            {
                i++;
                continue;
            }
            
            if(B[j][1] < A[i][0])
            {
                j++;
                continue;
            }
            
            List<Integer> l = new LinkedList<Integer>();
            if(A[i][0] < B[j][0])
            {
                l.add(B[j][0]);
                l.add(Math.min(A[i][1],B[j][1]));
            }
            else
            {
                l.add(A[i][0]);
                l.add(Math.min(A[i][1],B[j][1]));
            }
       
            if(A[i][1] < B[j][1]) i++;
            else j++;
            if(l.size() == 1) l.add(l.get(0));
            l1.add(l);
        }
       
        int ptr = 0;
        int[][] ans = new int[l1.size()][2];
        for(List<Integer> l : l1)
        {
            ans[ptr][0] = l.get(0);
            ans[ptr][1] = l.get(1);
            ptr++;
        }
        
        return ans;
    }
}
