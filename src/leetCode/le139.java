class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> hs = new HashSet<String>();
        int len = 0;
        
        for(String s1 : wordDict) 
        {
            hs.add(s1);
            len++;
        }
        
        if(len == 0) return false;
        
        HashSet<Integer> hs1 = new HashSet<Integer>();
        hs1.add(-1);
        
        len = s.length();
        
        List<Integer> l = new LinkedList<Integer>();
        int size = 0;
        
        for(int i = 0 ; i < len ; i++)
        {
            size = 0;
            for(int j : hs1) 
            {
                if(hs.contains(s.substring(j+1,i+1)))
                {
                    l.add(i);
                    size++;   
                }
            }
            
            while(size != 0) 
            {
                hs1.add(l.get(0));
                l.remove(0);
                size--;
            }
        }
        
        return hs1.contains(len-1);
    }
}
