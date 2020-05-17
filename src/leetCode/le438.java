class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> l = new LinkedList<Integer>();
        if(s.length() == 0) return l;
        HashMap<Character,Integer> hm = new HashMap<>();
        HashMap<Character,Integer> hm1 = new HashMap<>();
        
        for(char c : p.toCharArray())
            hm.put(c,hm.getOrDefault(c,0)+1);
        int i = 0;
        
        for(int j = 0 ; j <= s.length() ; j++)
        {
            boolean flag = true;
            if(j-i < p.length()) 
            {
                if(j == s.length()) break;
                char c = s.charAt(j);
                if(hm.containsKey(c)) hm1.put(c,hm1.getOrDefault(c,0)+1);
                continue;
            }
            if(hm.size() == hm1.size())
            {
                for(char d : hm.keySet())
                {
                    int a = hm.get(d);
                    int b = hm1.get(d);
                    if(a != b)
                    {
                        flag = false;
                        break;
                    }
                }
                if(flag) l.add(i);
            }
            
            if(j == s.length()) break;
            char c = s.charAt(j);
            char d = s.charAt(i);
            
            if(hm1.containsKey(d))
            {
                hm1.put(d,hm1.get(d)-1);
                if(hm1.get(d) == 0) hm1.remove(d);    
            }
            i++;
            if(hm.containsKey(c)) hm1.put(c,hm1.getOrDefault(c,0)+1);
        }
        return l;
    }
}
