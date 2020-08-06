class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> hs = new HashSet<>(Arrays.asList(deadends));
        if(hs.contains("0000")) return -1;
        
        Queue<String> q = new LinkedList<>();
        HashSet<String> v = new HashSet<>();
        HashSet<String> tgt = new HashSet<>();
        
        tgt.add(target);
        q.add("0000");
        v.add("0000");
        int size = 0, step = 1;
        String s = "";
        
        while(!q.isEmpty())
        {
            size = q.size();
            for(int j = 0 ; j < size ; j++)
            {
                s = q.poll();
                for(int i = 0 ; i < 4 ; i++)
                {
                    char curr = s.charAt(i);
                    String s1 = s.substring(0,i) + (curr == '9' ? "0": curr - '0' + 1) + s.substring(i+1) ;
                    String s2 = s.substring(0,i) + (curr == '0' ? "9": curr - '0' - 1) + s.substring(i+1) ;
                    
                    if(!v.contains(s1) && !hs.contains(s1)) 
                    {
                        if(tgt.contains(s1)) return step;
                        q.add(s1);
                        v.add(s1);
                    }
                    
                    if(!v.contains(s2) && !hs.contains(s2)) 
                    {
                        if(tgt.contains(s2)) return step;
                        q.add(s2);
                        v.add(s2);
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
