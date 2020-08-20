class Solution {
    public int shortestSubarray(int[] A, int K) {
        Queue<Integer> q = new LinkedList<>();
        int ans = Integer.MAX_VALUE, sum = 0, size = 0;
        int len = A.length, temp = 0;
        
        if(A[0] >= K) return 1;
        int[] dp = new int[len + 1];
        dp[0] = 0;
        
        for(int i = 1 ; i <= len ; i++) dp[i] = dp[i-1] + A[i-1];
       
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(0);
        
        for(int i = 1 ; i <= len ; i++)
        {
            while(!dq.isEmpty() && dp[i] - dp[dq.peekFirst()] >= K)
            {
                ans = Math.min(ans,i - dq.peekFirst());
                dq.pollFirst();
            }
            
            while(!dq.isEmpty() && dp[dq.peekLast()] >= dp[i]) dq.pollLast();
            
            dq.add(i);
        }
        
        return ans != Integer.MAX_VALUE ? ans : -1;
    }
}
