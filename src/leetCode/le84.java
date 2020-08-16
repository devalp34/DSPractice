class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        
        int ans = 0, len = heights.length, top = 0;
        
        for(int i = 0 ; i < len ; i++)
        {
            if(st.isEmpty() || heights[st.peek()] <= heights[i]) st.push(i);
            else  
            {
                while(heights[st.peek()] > heights[i])
                {
                    top = heights[st.peek()];
                    st.pop();
                    if(!st.isEmpty()) 
                        ans = Math.max(ans, top * (i - st.peek() - 1));
                    else
                    {
                        ans = Math.max(ans, top * i);
                        break;   
                    }    
                }
                st.push(i);
            }
        }
        
        while(!st.isEmpty())
        {
            top = heights[st.peek()];
            st.pop();
            
            if(st.isEmpty())
                ans = Math.max(ans, top * len);
            else
                ans = Math.max(ans, top * (len - st.peek() - 1));
        }
        
        return ans;
    }
}
