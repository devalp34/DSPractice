class Solution {
    int[] map, nc;
    int ans;
    
    public int getMaxLen(int[] nums) {
        int len = nums.length, nCount = 0, nCluster = 0, pCluster = 0;
        int curr = 0, anchor = 0;
            
        ans = Integer.MIN_VALUE;
        map = new int[len];
        nc = new int[len];
        
        if(nums[0] > 0) ans = map[0] = pCluster = 1;
        else if(nums[0] < 0) nc[0] = nCount = nCluster = 1;
        else anchor = 1;
        
        for(int i = 1 ; i < len ; i++)
        {
            curr = nums[i];
            
            if(curr == 0)
            {
                if(nums[i-1] < 0)
                    nc[i-nCluster] = nc[i-1] = nCluster;
                else if(nums[i-1] > 0) 
                    map[i-pCluster] = map[i-1] = pCluster;
                
                calc(anchor,i,nCount);
                map[i] = nc[i] = -1;
                pCluster = nCluster = nCount = 0;
                anchor = i+1;
                continue;
            }
            
            if(curr > 0)
            {
                if(nums[i-1] > 0) pCluster++;
                else if(nums[i-1] < 0)
                {
                    nc[i-nCluster] = nc[i-1] = nCluster;
                    nCluster = 0;
                    pCluster = 1;
                }
                else pCluster = 1;
                if(i == len - 1) 
                {
                    map[i] = pCluster;
                    map[i - pCluster + 1] = pCluster;
                    calc(anchor,len,nCount); 
                }
            }
            else
            {
                nCount++;
                if(nums[i-1] < 0) nCluster++;
                else if(nums[i-1] > 0)
                {
                    map[i - pCluster] = map[i-1] = pCluster;
                    pCluster = 0;
                    nCluster = 1;
                }
                else nCluster = 1;
                if(i == len - 1) 
                {
                    nc[i] = nCluster;
                    nc[i - nCluster + 1] = nCluster;
                    calc(anchor,len,nCount); 
                }
            }
        }
        return ans != Integer.MIN_VALUE ? ans : 0;
    }
    
    void calc(int st, int e, int negCount)
    {
        if(negCount % 2 == 0) 
        {
            ans = Math.max(ans, e - st);
            return;
        }
        
        int tempNeg = negCount, ptr = st, len = 0, t = 0;
        while(ptr < e)
        {
            if(map[ptr] == 0)
            {
                tempNeg -= nc[ptr];
                if(tempNeg > 0)
                {
                    len += nc[ptr];
                    t = nc[ptr];
                    ptr += t;
                }
                else
                {
                    ans = Math.max(ans, nc[ptr] - 1 + len);
                    break;
                }
            }
            else
            {
                len += map[ptr];
                t = map[ptr];
                ptr += t;
            }
        }
        
        len = 0;
        ptr = e - 1;
        tempNeg = negCount;
        
        while(ptr >= st)
        {
            if(map[ptr] == 0)
            {
                tempNeg -= nc[ptr];
                if(tempNeg > 0)
                {
                    len += nc[ptr];
                    t = nc[ptr];
                    ptr -= t;
                }
                else
                {
                    ans = Math.max(ans, len + nc[ptr] - 1);
                    return;
                }
            }
            else
            {
                len += map[ptr];
                t = map[ptr];
                ptr -= t;
            }
        }
        return;
    }
}
