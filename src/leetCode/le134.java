class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = cost.length, size = 0, i = 0;
        
        HashSet<Integer> notStart = new HashSet<>();
        
        while(size < len)
        {
            if(gas[i] < cost[i]) notStart.add(i);
            else if(dfs(i, new HashSet<Integer>() ,0 + gas[i], len, gas, cost)) 
                return i;
            else notStart.add(i);
            i++;
            size++;
        }
        
        return -1;
    }
    
    boolean dfs(int curr, HashSet<Integer> v, int remain, int len, int[] g, int[] c)
    {
        int index = curr % len;
        if(v.contains(index)) return true;
        if(remain < c[index]) return false;
        
        v.add(index);
        return dfs(curr+1,v,remain - c[index] + g[(curr+1) % len], len, g, c);
    }
}
