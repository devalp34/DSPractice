class Solution {
    int[] arr;
    public int[] findRedundantConnection(int[][] edges) {
        arr = new int[edges.length+1];
        for(int i = 0 ; i < arr.length ; i++) arr[i] = i;
        for(int[] a : edges)
        {
            int iRoot = root(a[0]);
            int jRoot = root(a[1]);
            if(iRoot != jRoot) arr[iRoot] = jRoot;
            else return a;
        }
        return arr;
    }
    
    int root(int i)
    {
        while(i != arr[i]) i = arr[i];    
        return i;
    }
}
