class Solution {
    public boolean checkValidString(String s) 
    {
        Stack<Character> stack = new Stack<>(); 
        Stack<Integer> li = new Stack<>();
        Stack<Integer> ri = new Stack<>();
        Stack<Integer> ast = new Stack<>();
        
        for(int i = 0 ; i < s.length() ; i++)
        {
            char c = s.charAt(i);
            if(c == '(') 
            {
                stack.push(c);
                li.push(i);   
            }
            else if(c == ')')
            {
                if(stack.size() > 0) 
                {
                    if(stack.peek() == '(')
                    {
                        stack.pop();
                        li.pop();   
                    }
                    else 
                    {
                        stack.push(c);
                        ri.push(i);
                    }
                }
                else
                {
                    if(ast.size() > 0) ast.pop();
                    else 
                    {
                        stack.push(c);
                        ri.push(i);
                    }
                }
            }
            else ast.push(i);
        }
        
        if(stack.size() == 0) return true;
        if(ast.size() == 0) return false;
        while(ast.size() > 0 && (li.size() > 0 || ri.size() > 0))
        {
            if(li.size() > 0 && li.peek() < ast.peek())
            {
                li.pop();
                ast.pop();
            }
            else if(ri.size() > 0 && ri.peek() > ast.peek())
            {
                ri.pop();
                ast.pop();
            }
            else ast.pop();
        }
        return li.size() == 0 && ri.size() == 0;
    }
}
