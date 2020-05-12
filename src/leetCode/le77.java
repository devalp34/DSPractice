class Solution {
    List<List<Integer>> ans = new LinkedList<List<Integer>>();
    public List<List<Integer>> combine(int n, int k) {
        int[] a = new int[n];
        for(int i = 1 ; i <= n ; i++) a[i-1] = i;
        backtrac(a,k,new LinkedList<Integer>(),0);
        return ans;
    }
    
    public void backtrac(int[] a,int k, List<Integer> l,int j)
    {
        if(l.size() == k) 
        {
            ans.add(new LinkedList<Integer>(l));
            return;
        }
        for(int i = j ; i < a.length ; i++)
        {
            if(l.contains(a[i])) continue;
            l.add(a[i]);
            backtrac(a,k,l,i+1);
            l.remove(l.size()-1);
        }
    }
}
