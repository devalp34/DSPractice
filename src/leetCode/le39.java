class Solution {
    List<List<Integer>> ans = new LinkedList<List<Integer>>();
    int t = 0;
    public List<List<Integer>> combinationSum(int[] candidates, int target)     {
        t = target;
        bt(candidates,new LinkedList<Integer>(),0,0);
        return ans;
    }
    
    void bt(int[] c, List<Integer> l, int j ,int sum)
    {
        if(sum == t)
        {
            ans.add(new LinkedList<Integer>(l));
            return;
        }
        if(sum > t) return;
        
        for(int i = j ; i < c.length ; i++)
        {
            sum += c[i];
            l.add(c[i]);
            bt(c,l,i,sum);
            sum -= c[i];
            l.remove(l.size()-1);
        }
    }
}
