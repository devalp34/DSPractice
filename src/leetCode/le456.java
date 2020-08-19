class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int curr = 0, min = 0, len = nums.length;
        
        if(len < 3) return false;
        
        int[] minArray = new int[len];
        minArray[0] = nums[0];
        
        for(int i = 1 ; i < len ; i++)
            minArray[i] = Math.min(minArray[i-1],nums[i]);
        
        st.push(nums[len-1]);
        
        for(int i = len - 2 ; i >= 0 ; i--)
        {
            curr = nums[i];
            min = minArray[i];
            
            if(curr > st.peek())
            {
                if(min < st.peek()) return true;
                else
                {
                    while(!st.isEmpty() && min >= st.peek()) st.pop();
                    if(!st.isEmpty() && st.peek() < curr) return true;
                }
            }
            st.push(curr);
        }
        
        return false;
    }
}























// for(int i : nums)
//         {
//             if(!st.isEmpty() && size > 1 && st.peek() > i && min < i) 
//                 return true;
            
//             if(st.isEmpty()) 
//             {
//                 st.push(i);
//                 min = Math.min(min,i);
//                 size++;   
//             }
//             else if(min >= i)
//             {
//                 while(!st.isEmpty()) st.pop();
//                 st.push(i);
//                 min = i;
//                 size = 1;
//             }
//             else if(st.peek() >= i)
//             {
//                 st.pop();
//                 st.push(i);
//             }
//             else
//             {
//                 st.push(i);
//                 size++;
//             }
//         }
