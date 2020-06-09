class Solution {
    public String findLongestWord(String s, List<String> d) {
        if(s.length() == 0 || d.size() == 0) return "";
        int len = s.length(), aLen = 0, sLen = 0;
        String ans = "";
        
        for(String str : d)
        {
            sLen = str.length();
            if(sLen > len) continue;
            if(findString(s,str)) 
            {
                if(aLen <= sLen)
                {
                    if(aLen < sLen) ans = str;
                    else if(ans.compareTo(str) > 0) ans = str;
                }    
            }
            aLen = ans.length();
        }
        
        return ans;
    }
    
    boolean findString(String s, String tgt)
    {
        int i = 0, j = 0, sLen = s.length(), tLen = tgt.length();
        while(i < sLen && j < tLen)
        {
            if(s.charAt(i) == tgt.charAt(j)) j++;
            i++;
        }
        
        return j == tLen;
    }
}
