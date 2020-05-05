class Solution {
    
    public int findMinFibonacciNumbers(int k) 
    {
        int a = 1, b = 1, c = 0, min = Integer.MAX_VALUE;
        if(k == 1) return 1;
        List<Integer> l = new LinkedList<Integer>();
        l.add(1);
        
        while((a+b) <= k)
        {
            c = a+b;
            if(k % c == 0) min = Math.min(min,k/c);
            if(c == k) return 1;
            l.add(c);
            a = b;
            b = c;
        }
        
        c = k - l.get(l.size()-1);
        int count = 1;
        for(int i = l.size() - 2 ; i >= 0 ; i--)
        {
            int t = c - l.get(i);
            if(t == 0) return Math.min(min,count+1);
            if(t > 0)
            {
                count++;
                c = t;
            }
        }
        return Math.min(min,count);
    }
}
