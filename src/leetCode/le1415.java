class Solution {
    List<String> l = new LinkedList<String>();
    HashSet<String> hs = new HashSet<>();
    char[] letter = {'a','b','c'};
    
    public String getHappyString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        bt(sb,n);
        for(String s : hs)
        {
            l.add(s);
        }
        Collections.sort(l);
        if(l.size() >= k) return l.get(k-1);
        else return "";
    }
    
    void bt(StringBuilder sb, int length)
    {
        if(sb.length() == length) 
        {
            hs.add(sb.toString());
            return;
        }
        
        for(int i = 1 ; i <= letter.length ; i++)
        {
            if(sb.length() == 0) 
            {
                sb.append(letter[i-1]);
                bt(sb,length);
                sb.delete(0,1);
                continue;
            }
            if(sb.toString().charAt(sb.length()-1) == letter[i-1]) 
                    continue;
            sb.append(letter[i-1]);
            bt(sb,length);
            sb.delete(sb.length()-1,sb.length());
        }
        return;
    }
}
