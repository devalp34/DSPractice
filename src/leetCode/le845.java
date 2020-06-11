class Solution {
    public int longestMountain(int[] A) {
        if(A.length < 3) return 0;
        boolean up = false, down = false, completed = false;
        int back = 0 , front = 0, prev = 0, ans = 0;
        
        while(back < A.length -1 && A[back] >= A[back+1]) back++;
        if(A.length - back <= 2) return 0;
        
        up = true;
        prev = back;
        front = back + 1;
        
        while(front < A.length)
        {
            if(A[front] > A[prev]) 
            {
                if(down)
                {
                    ans = Math.max(ans,front - back);
                    up = true;
                    down = false;
                    back = prev;
                }
                prev = front;
                front++;
            }
            else if(A[front] < A[prev])
            {
                if(up)
                {
                    up = false;
                    down = true;
                }
                prev = front;
                front++;
            }
            else
            {
                if(down) ans = Math.max(ans,front - back);
                
                int ptr = front;
                while(ptr < A.length - 1 && A[ptr] >= A[ptr + 1]) ptr++;
                front = ptr + 1;
                up = true;
                down = false;
                prev = ptr;
                back = prev;
            }
        }
        ans = Math.max(ans,front - back);
        
        if(ans == A.length)
        {
            if(down) return ans;
            else return 0;
        }
        
        if(ans > 2) return ans;
        return 0;
    }
}
