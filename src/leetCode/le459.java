class Solution {
    public boolean repeatedSubstringPattern(String s) {
        HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
        for(char c : s.toCharArray())
            hm.put(c,hm.getOrDefault(c,0)+1);
        
        StringBuilder sb = new StringBuilder("");
        HashMap<Character,Integer> hm1 = new HashMap<Character,Integer>();
        HashSet<Character> hs = new HashSet<Character>();
        for(int i = 0 ; i < s.length() / 2 ; i++) 
        {
            char c = s.charAt(i);
            sb.append(c);
            hs.add(c);
            hm1.put(c,hm1.getOrDefault(c,0)+1);
            boolean flag = true;
            if(hs.size() == hm.size())
            {
                for(char d : hm.keySet())
                {
                    if(hm.get(d) % hm1.get(d) != 0) 
                    {
                        flag = false;
                        break;
                    }
                }
                if(flag)
                {
                    for(int j = 0 ; j < s.length() ; j += sb.length())
                    {
                      if(!s.substring(j,j+sb.length()).equals(sb.toString()))
                            break;
                      if(j == s.length()-sb.length()) return true;
                    }
                }
            }
        }
        return false;
    }
}
