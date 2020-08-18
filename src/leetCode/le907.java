class Solution {
    public int sumSubarrayMins(int[] A) {
        Stack<Integer> st = new Stack<>();
        
        int len = A.length, idx = 0, top = 0, mod = ((int)Math.pow(10,9))+7;
        long ans = 0L;
        
        for(int i = 0 ; i < len ; i++)
        {
            if(st.isEmpty() || A[st.peek()] <= A[i]) st.push(i);
            else
            {
                while(!st.isEmpty() && A[st.peek()] > A[i])
                {
                    idx = st.pop();
                    top = A[idx];
                    
                    if(st.isEmpty())
                        ans += ((i - idx)*(idx + 1)* top);
                    else
                        ans += (((idx - st.peek()) * (i - idx)) * top);
                }
                st.push(i);
            }
            ans %= mod; 
        }
        
        while(!st.isEmpty())
        {
            idx = st.pop();
            top = A[idx];
            if(!st.isEmpty())
                ans += ((idx - st.peek()) * (len - idx)) * top;
            else
                ans += (len - idx) * (idx + 1) * top;
            
            ans %= mod;
        }
        return (int) ans;
    }
}
