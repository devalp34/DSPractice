class Solution {
    public int maximalRectangle(char[][] matrix) {
        int colLen = matrix.length;
        if(colLen == 0) return 0;
        
        int rowLen = matrix[0].length, ans = 0, top = 0;
        int[] dp = new int[rowLen];
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0 ; i < colLen ; i++)
        {
            for(int j = 0 ; j < rowLen ; j++)
            {
                if(matrix[i][j] == '1') dp[j]++;
                else dp[j] = 0;
            }
            
            for(int j = 0 ; j < rowLen ; j++)
            {
                if(st.isEmpty() || dp[st.peek()] <= dp[j]) st.push(j);
                else
                {
                    while(dp[st.peek()] > dp[j])
                    {
                        top = dp[st.peek()];
                        st.pop();
                        if(st.isEmpty())
                        {
                            ans = Math.max(ans, top * j);  
                            break;
                        }
                        else
                            ans = Math.max(ans, top * (j - st.peek() - 1));                       }
                    st.push(j);
                }
            }
            
            while(!st.isEmpty())
            {
                top = dp[st.peek()];
                st.pop();
                
                if(st.isEmpty())
                    ans = Math.max(ans, top * rowLen);
                else
                    ans = Math.max(ans, top * (rowLen - st.peek() - 1));
            }
        }
        
        return ans;
    }
}
