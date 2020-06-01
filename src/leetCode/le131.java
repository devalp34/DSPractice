class Solution {
    List<List<String>> ans = new LinkedList<List<String>>();
    
    public List<List<String>> partition(String s) {
        if(s.length() == 0) return ans;
        bt(s,new LinkedList<String>(),0);
        return ans;
    }
    
    void bt(String s, List<String> l, int start)
    {
        if(start >= s.length())
        {
            ans.add(new LinkedList<String>(l));
            return;
        }
        
        for(int j = start ; j < s.length(); j++)
        {
            String s1 = s.substring(start,j+1);
            if(isPalindrome(s1)) 
            {
                l.add(s1);
                bt(s,l,j+1);
                l.remove(l.size() - 1);
            }
        }
    }
    
    boolean isPalindrome(String s)
    {
        StringBuilder sb = new StringBuilder(s);
        if(sb.reverse().toString().equals(s)) return true;
        else return false;
    }
}
