class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> l = new LinkedList<String>();
        HashMap<Integer,List<String>> hm = new HashMap<Integer,List<String>>();
        List<String> l2 = Arrays.asList(list2);
        
        for(int i = 0 ; i < list1.length ; i++) 
        {
            if(l2.indexOf(list1[i]) != -1) l.add(list1[i]);
        }
        
        List<Integer> temp = new LinkedList<Integer>();
        List<String> l3 = Arrays.asList(list1);
        for(String s : l)
        {
            int l1 = l3.indexOf(s);
            l1 += l2.indexOf(s);
            List<String> ls;
            if(hm.containsKey(l1))
            {
                ls = hm.get(l1);
                ls.add(s);
                hm.put(l1,ls);
            }
            else
            {
                ls = new LinkedList<String>();
                ls.add(s);
                hm.put(l1,ls);
            }
                temp.add(l1);
        }
        l.clear();
        Collections.sort(temp);
        l = hm.get(temp.get(0));
        String[] ans = new String[l.size()];
        for(int i = 0 ; i < l.size() ; i++)
            ans[i] = l.get(i);
    
        return ans;
    }
}
