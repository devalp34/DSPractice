class Solution {
    public int findBestValue(int[] arr, int target) {
        
        Arrays.sort(arr);
        int len = arr.length, mid = 0, minDiff = Integer.MAX_VALUE, ans = 0;
        int temp = 0, high = arr[len - 1], low = 1;
            
        if(target < len) return 0;
        
        while(low <= high)
        {
            mid = (low + high) / 2;
            for(int i = 0 ; i < len ; i++)
            {
                if(arr[i] <= mid) temp += arr[i];
                else
                {
                    temp += (mid * (len - i));
                    break;
                }
            }    
            
            if(minDiff > Math.abs(target - temp)) 
            {
                minDiff = Math.abs(target - temp);
                ans = mid;
            }
            
            if(temp == target || low == high) return ans;
            
            if(temp > target) high = mid;
            else low = mid + 1;
            temp = 0;
        }
        return ans;
    }
}
