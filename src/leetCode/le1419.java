class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) 
    {
        if(croakOfFrogs.length() < 5) return -1;
        int[] cr = new int[5];
        int fr = 0;
        for(char c : croakOfFrogs.toCharArray())
        {
            if(c == 'c')
            {
                cr[0]++;
                fr = Math.max(fr,cr[0]);
                continue;   
            }
            if(c == 'r')
            {
                if(cr[1] < cr[0]) cr[1]++;
                else return -1;
                continue;
            }
            if(c == 'o')
            {
                if(cr[2] < cr[1]) cr[2]++;
                else return -1;
                continue;
            }
            if(c == 'a')
            {
                if(cr[3] < cr[2]) cr[3]++;
                else return -1;
                continue;
            }
            if(c == 'k')
            {
                if(cr[4] < cr[3])
                {
                    cr[3] = cr[3]-1;
                    cr[2] = cr[2]-1;
                    cr[1] = cr[1]-1;
                    cr[0] = cr[0]-1;
                }
                else return -1;
                //System.out.println(cr[4]);
                continue;
            }
        }
        
        for(int i : cr) if(i != 0) return -1;
        
        return fr;
    }
}
