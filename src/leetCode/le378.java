class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int rowLen = matrix[0].length;
        int colLen = rowLen, count = 0, ans = 0;
        
        if(k == rowLen * rowLen) return matrix[rowLen-1][rowLen-1];
        
        boolean[][] v = new boolean[colLen][rowLen];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((e1,e2) -> matrix[e1[0]][e1[1]] - matrix[e2[0]][e2[1]]);
        
        pq.add(new int[]{0,0});
        v[0][0] = true;
        
        while(count < k)
        {
            int[] a = pq.poll();
            count++;
            if(count == k) return matrix[a[0]][a[1]];
            
            if(a[0]+1 < colLen && !v[a[0]+1][a[1]])
            {
                pq.add(new int[]{a[0]+1,a[1]});
                v[a[0]+1][a[1]] = true;   
            }
            
            if(a[1]+1 < rowLen && !v[a[0]][a[1]+1])
            {
                pq.add(new int[]{a[0],a[1]+1});
                v[a[0]][a[1]+1] = true;
            }
        }
        
        return -1;
    }
}
