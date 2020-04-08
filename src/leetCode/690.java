/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        HashMap<Integer,List<Integer>> l1 = new HashMap<Integer,List<Integer>>();
        
        int ans = 0;
        for(Employee e : employees)
        {
            hm.put(e.id,e.importance);
            l1.put(e.id,e.subordinates);
        }
            
        HashSet<Integer> hs = new HashSet<Integer>();
        List<Integer> l = null;
        for(Employee e : employees)
        {
            if(e.id == id)
            {
                ans += hm.get(e.id);
                l = e.subordinates;
                hs.add(e.id);
            }
        }
        
        for(int i = 0 ; i < l.size() ; i++)
        {
            if(!hs.contains(l.get(i)))
            {
                ans += hm.get(l.get(i));
                List<Integer> temp = l1.get(l.get(i));
                if(temp.size() > 0) l.addAll(temp);    
            }
            //else 
        }
        return ans;
    }
}
