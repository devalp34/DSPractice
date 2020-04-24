class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if(n == 0 || m == 0) return 0;
        if(n == 1 ) return 1;
        if((Integer.toBinaryString(m).length() - Integer.toBinaryString(n).length()) != 0) return 0;
        if(n == m) return m;
        int t = m & m+1;
        if(m+1 ==Integer.MAX_VALUE) return t; 
        for(int i = m+2 ; i <= n ; i++) t = t & i;
        return t;
    }
}
