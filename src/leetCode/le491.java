class Solution {
    Set<List<Integer>> ans = new HashSet<>();
    
    public List<List<Integer>> findSubsequences(int[] nums) {
        if(nums.length == 0) return new ArrayList<List<Integer>>(ans);
        dfs(nums,-101,0, new LinkedList<Integer>());
        return new ArrayList<List<Integer>>(ans);
    }
    
    void dfs(int[] n, int last, int curr, List<Integer> l)
    {
        if(curr == n.length) return;
        
        if(last <= n[curr])
        {
            l.add(n[curr]);
            last = n[curr];
            if(l.size() > 1) ans.add(List.copyOf(l));
            dfs(n,last,curr+1,l);
            l.remove(l.size()-1);
            if(l.size() > 0) last = l.get(l.size() - 1);    
            else last = -101;
            dfs(n,last,curr+1,l);
        }
        else dfs(n,last,curr+1,l);
    }
}
