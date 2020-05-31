class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        List<Integer> ht = new LinkedList<Integer>();// For horizontal cut
        List<Integer> vt = new LinkedList<Integer>();// For vertical cut
        
        int ptr = 0;
        // Horizontal cut difference
        for(int i = 0 ; i < horizontalCuts.length ; i++)
        {
            if(i == 0) ht.add(horizontalCuts[i]); // For first cut
            else ht.add(horizontalCuts[i] - horizontalCuts[i-1]);
        }
        
        ht.add(h - horizontalCuts[horizontalCuts.length - 1]); // For last cut 
        
        // Vertical cut difference
        for(int i = 0 ; i < verticalCuts.length ; i++)
        {
            if(i == 0) vt.add(verticalCuts[i]); // First Cut
            else vt.add(verticalCuts[i] - verticalCuts[i-1]); // Last cut
        }
        vt.add(w - verticalCuts[verticalCuts.length - 1]);
        
        int lmax = Collections.max(ht); // Taking max from horizontal cut
        int vmax = Collections.max(vt); // Taking max from vertical cut
        
        long ans = lmax * vmax;
        ans = ans % ((int)(Math.pow(10,9)) + 7);
        return (int) ans; 
    }
}
