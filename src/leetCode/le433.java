class Solution {
    public int minMutation(String start, String end, String[] bank) {
        HashMap<String,Integer> hm = new HashMap<>();
        Queue<String> q = new LinkedList<String>();
        
        q.add(start);
        hm.put(start,0);
        String curr = "";
        int len = start.length(), misMatch = 0;
        
        if(len == 0 || bank.length == 0) return -1;
        
        while(!q.isEmpty())
        {
            curr = q.poll();
            for(String s : bank)
            {
                if(hm.containsKey(s)) continue;
                for(int i = 0 ; i < len ; i++)
                {
                    if(s.charAt(i) != curr.charAt(i)) misMatch++;
                    if(misMatch > 1) break;
                }
                if(misMatch <= 1)
                {
                    hm.put(s,hm.get(curr)+1);
                    if(s.equals(end)) return hm.get(s);
                    q.add(s);
                }
                misMatch = 0;
            }
        }
        return -1;
    }
}
