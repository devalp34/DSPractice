class Solution {
    public int countTriplets(int[] arr) {
        if(arr.length < 2) return 0;
        int i = 0, j = i+1;
        int k = j, count = 0, ax = arr[i], bx = arr[j];
        boolean flag = false;
        while(i < arr.length-1)
        {
            if(ax == bx) count++;
            if(k+1 < arr.length) 
            {
                k++;
                bx ^= arr[k];
            }
            else if(j+1 < arr.length)
            {
                ax ^= arr[j]; 
                j++;
                bx = arr[j];
                k = j;
            }
            else 
            {
                ax = arr[i+1];
                i++;
                k = j = i+1;
                if(j < arr.length)bx = arr[j];
                else break;
            }
        }
        return count;
    }
}
