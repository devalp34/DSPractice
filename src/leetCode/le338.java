class Solution {
    public int[] countBits(int num) {
        if(num == 0) return new int[1];
        
        int power = 0, anchor = 0, i = 1;
        int[] a = new int[num+1];
        a[0] = 0;
        
        while(i <= num)
        {
            if((int)Math.pow(2,power) == i)
            {
                power++;
                anchor = i;
                a[i++] = 1;
                continue;
            }
            else
            {
                int t = a[anchor] + a[i - anchor];
                a[i++] = t;
            }
        }
        return a;
    }
}
