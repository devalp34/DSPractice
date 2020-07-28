class Solution {
    public int compress(char[] chars) {
        int acr = 0, cnt = 1, len = chars.length;
        char prev = chars[0];
        
        for(int i = 1 ; i < len ; i++)
        {
            if(chars[i] == prev) cnt++;
            else 
            {
                acr = enter(chars,acr,prev,cnt);
                prev = chars[i];
                cnt = 1;
            }
        }
        return enter(chars,acr,prev,cnt);
    }
    
    int enter(char[] chars, int acr, char prev, int cnt)
    {
        chars[acr++] = prev;
        if(cnt > 1)
        {
            int cntLen = (int)Math.log10(cnt) + 1;
            String counter = Integer.toString(cnt);
            for(int j = 0 ; j < cntLen ; j++) 
                chars[acr++] = counter.charAt(j);
        }
        return acr;
    }
}
