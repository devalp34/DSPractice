class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        dfs d = new dfs();
        HashMap<String,String> hm = new HashMap<>();
        HashMap<String,Integer> hm1 = new HashMap<>();
        int id = 0;
        for(List<String> l : accounts)
        {
            String n = "";
            for(String s : l)
            {
                if(n == "")
                {
                    n = s;
                    continue;
                }
                if(!hm1.containsKey(s)) hm1.put(s,id++);
                hm.put(s,n);
                d.union(hm1.get(l.get(1)),hm1.get(s));
            }
        }
        HashMap<Integer,List<String>> hm2 = new HashMap();
        for(String s : hm1.keySet())
        {
            int i = d.find(hm1.get(s));
            hm2.computeIfAbsent(i,x -> new LinkedList<String>()).add(s);
        }
        for(List<String> l : hm2.values())
        {
            Collections.sort(l);
            l.add(0,hm.get(l.get(0)));
        }
        return new LinkedList(hm2.values());
    }
    
    class dfs
    {
        int[] p = new int[100000];
        dfs()
        {
            for(int i = 0 ; i < p.length ; i++) p[i] = i;    
        }
        void union(int x, int y)
        {
            p[find(x)] = find(y);
        }
        int find(int x)
        {
            if(p[x] == x) return p[x];
            return p[x] = find(p[x]);
        }
    }
}
