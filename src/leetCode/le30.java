class Solution {
    int strLen, winLen;
    HashMap<String,Integer> wfreq = new HashMap<>();
    HashMap<String,Integer> index = new HashMap<>();
    
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new LinkedList<Integer>();  
        if(words.length == 0) return ans;
        
        int ptr = 0, len = s.length();
        strLen = words[0].length();
        winLen = words.length * strLen;
        
        if(len == 0  || winLen == 0) return ans;
        
        for(String s1 : words)
        {
            wfreq.put(s1,wfreq.getOrDefault(s1,0)+1);
            if(!index.containsKey(s1)) index.put(s1,ptr++);
        }
        
        for(int i = 0 ; i <= len - winLen ; i++)
        {
            if(findIndex(i, new int[index.size()], i + winLen, s))
                ans.add(i);
        }
        
        return ans;
    }
    
    boolean findIndex(int start, int[] freq, int end, String s)
    {
        int temp = 0;
        for(int i = start ; i < end ; i += strLen)
        {
            temp = i+strLen;
            String s1 = s.substring(i, temp);
            if(index.containsKey(s1))
            {
                freq[index.get(s1)]++;
                if(freq[index.get(s1)] > wfreq.get(s1)) return false;
            }
            else return false;
        }
        return true;
    }
}
