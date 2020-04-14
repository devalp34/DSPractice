class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
     HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        for(int i : deck) hm.put(i,hm.getOrDefault(i,0)+1);
        List<Integer> l = new LinkedList<Integer>();
        for(Map.Entry me : hm.entrySet())
        {
            if(!l.contains((int)me.getValue())) l.add((int)me.getValue());
        }
        Collections.sort(l);
        boolean flag = true;
        for(int i = 2 ; i <= l.get(0) ; i++)
        {
            for(int j : l)
            {
                if(j % i != 0)
                {
                    flag = false;
                    break;
                }
            }
            if(flag) return true;
            else flag = true;
        }
        return false;
    }
}
