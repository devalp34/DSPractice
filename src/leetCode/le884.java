class Solution {
    public String[] uncommonFromSentences(String A, String B) 
    {
        HashMap<String,Integer> hm = new HashMap<String,Integer>();
        List<String> l = new LinkedList<String>();
        
        String[] sa = A.split(" ");
        String[] sb = B.split(" ");
        
        for(String s : sa) hm.put(s,hm.getOrDefault(s,0)+1);
        for(String s : sb) hm.put(s,hm.getOrDefault(s,0)+1);
        for(Map.Entry me : hm.entrySet())
        {
            int val = (int) me.getValue();
            if(val < 2) 
            {
                String k = (String) me.getKey();
                l.add(k);
            }
        }
        
        String[] ans = new String[l.size()];
        for(int i = 0 ; i < l.size() ; i++)
            ans[i] = l.get(i);
    
        return ans;
    }
}
