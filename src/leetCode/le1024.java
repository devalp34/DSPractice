class Solution {
    public int videoStitching(int[][] clips, int T) {
        if(T == 0) return 0;
        int[] time = new int[T+1];
        Arrays.sort(clips,(e1,e2) -> e1[0] == e2[0] ? e2[1] - e1[1] : e1[0] - e2[0]);
        int ptr = 0, counter = 1;
        Arrays.fill(time,-1);
        
        for(int[] c : clips)
        {
            if(c[0] > c[1]) continue;
            if(c[1] > T) c[1] = T;
            if(time[c[1]] == -1)
            {
                if(ptr == 0)
                {
                    for(int i = c[0] ; i <= c[1] ; i++)
                        time[i] = 1;
                }
                else if(time[c[0]] == -1) return -1;
                else
                {
                    int temp = Math.min(time[c[0]],time[ptr]);
                    for(int i = ptr+1 ; i <= c[1] ; i++) time[i] = temp+1;
                }
                counter = time[c[1]] + 1;
                ptr = c[1];
            }
        }
        
        for(int i : time) 
        {
            if(i == -1) return -1;
        }
        
        return time[T];
    }
}
