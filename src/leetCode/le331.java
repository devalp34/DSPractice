class Solution {
    public boolean isValidSerialization(String preorder) {
        Stack<String> ls = new Stack<>();
        Stack<String> rs = new Stack<>();
        Stack<String> st = new Stack<>();
        boolean prev = false;
        String[] sa = preorder.split("\\,");
        
        if(!sa[0].equals("#"))
        {
            ls.push(sa[0]);
            st.push(sa[0]);    
        }
        
        for(int i = 1 ; i < sa.length ; i++)
        {
            if(st.size() == 0) return false;
            String c = sa[i];
            if(!c.equals("#")) 
            {
                ls.push(c);
                st.push(c);
                prev = false;
            }
            else
            {
                if(!prev)
                {
                    prev = true;
                }
                else
                {
                    if(st.size() == 0) return false;
                    while(!rs.isEmpty() && rs.peek().equals(st.peek())) 
                    {
                        rs.pop();
                        st.pop();   
                    }
                }
                if(ls.size() > 0) rs.push(ls.pop());
            }
        }
        return st.size() == 0;
    }
}
