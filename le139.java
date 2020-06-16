class Solution {
    HashSet<String> hs = new HashSet<String>();
    boolean ans = false;
    
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length() == 0 || wordDict.size() == 0) return ans;
        
        for(String s1 : wordDict) hs.add(s1);
        traverse(0,s,s.length());
        
        return ans;
    }
    
    void traverse(int begin, String s, int len)
    {
        if(begin == len)
        {
            ans = true;
            return;
        }
        
        if(ans) return;
        
        int i = 0;
        for(i = begin ; i < len ; i++)
        {
            if(hs.contains(s.substring(begin,i+1)))
               traverse(i+1,s,len);
        }
    }
}
