class Solution {
    public boolean canReorderDoubled(int[] A) {
        boolean[] v = new boolean[A.length];
        Arrays.sort(A);
        
        int i = 0, len = A.length, dig = 0, index = -1;
        for(i = 0 ; i < len ; i++) 
        {
            if(v[i]) continue;
            
            if(A[i] < 0) dig = A[i]/2;
            else dig = A[i] * 2;
            
            index = find(dig,A,v,i,len);       
            
            if(index == -1) return false;
            else v[i] = v[index] = true;
        }
        return true;
    }
    
    int find(int d, int[] a, boolean[] v, int start, int len)
    {
        int i = 0;
        for(i = start+1 ; i < len ; i++)
        {
            if(v[i]) continue;
            if(a[i] == d) return i;
            else if(a[i] < d) continue;
            else return -1;
        }
        return -1;
    }
}
