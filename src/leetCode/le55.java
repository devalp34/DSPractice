class Solution {
    public boolean canJump(int[] nums) 
    {
        HashSet<Integer> hs = new HashSet<Integer>();
        if(nums.length == 1) return true;
        int dig = nums[0], max = 0;
        if(dig == 0) return false;
        max = Math.max(max,dig);
                
        while(dig != 0)
        {
            if(dig < nums.length-1) hs.add(dig--);
            else return true;
        }
        
        for(int i = 1 ; i < nums.length-1 ; i++)
        {
            if(hs.contains(i))
            {
                hs.remove(i);
                dig = nums[i];
                if((i+dig) > max)
                {
                    max = (i+dig);
                    while(dig != 0)
                    {
                        if(hs.contains(i+dig)) break;
                        if((i+dig) < nums.length-1) hs.add(i+dig);
                        else return true;
                        dig--;
                    }    
                }
            }
            else return false;
        }
        return false;
    }
}
