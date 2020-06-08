class Solution {
    int ptr;
    public int trap(int[] height) 
    {
        if(height.length < 2) return 0;
        int water = 0;
        ptr = 1;
        
        int[] my = new int[height.length];
        my[0] = 0;
        my[1] = 1;
        
        for(int i = 2 ; i< height.length ; i++)
        {
            if(height[i] > height[my[ptr]])
                water += findWater(my,height,i);
            my[ptr + 1] = i;
            ptr++;
        }
        
        return water;
    }
    
    int findWater(int[] m, int[] h, int index)
    {
        int temp = 0;
        while(ptr > 0 && h[m[ptr]] <= h[index] &&h[m[ptr]] <= h[m[ptr-1]])
        {
    temp += ((Math.min(h[m[ptr-1]], h[index]) - h[m[ptr]]) * (index- m[ptr-1] - 1)); 
            ptr--;            
        }
        return temp;
    }
}
