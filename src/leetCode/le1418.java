class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) 
    {
        List<List<String>> ans = new LinkedList<List<String>>();
        HashMap<String,List<String>> hm = new HashMap<String,List<String>>();// tbl and dishcolln
        HashSet<String> hs = new HashSet<String>();// table
        List<String> hs1 = new LinkedList<String>();// uniq dishes
        HashMap<String,Integer> hm1 = new HashMap<String,Integer>(); // dish count
        
        for(List<String> l : orders)
        {
            if(!hm.containsKey(l.get(1))) hm.put(l.get(1), new LinkedList<String>());
            List<String> l1 = hm.get(l.get(1));
            for(int i = 2 ; i < l.size() ; i++) 
            {
                l1.add(l.get(i));
                if(!hs1.contains(l.get(i)))hs1.add(l.get(i));   
            }
            hm.put(l.get(1),l1);
        }
        
        Collections.sort(hs1);
        for(Map.Entry me : hm.entrySet())
        {
            List<String> l = (List<String>)me.getValue();
            for(String s : l) hm1.put(s,hm1.getOrDefault(s,0)+1);
            l.clear();
            l.add((String)me.getKey());
            for(String s : hs1)
            {
                if(hm1.containsKey(s)) l.add(Integer.toString(hm1.get(s)));
                else l.add("0"); 
            }
            ans.add(l);
            hm1.clear();
        }
        
        Collections.sort(ans, new Comparator<List<String>>(){
            public int compare(List<String> a, List<String> b)
            {
                return Integer.parseInt(a.get(0))-Integer.parseInt(b.get(0));
            }
        });
        
        hs1.add(0,"Table");
        ans.add(0,hs1);
        return ans;
    }
}
