class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        List<Integer> l = new LinkedList<Integer>();
        int[] d = new int[deck.length];
        
        for(int i : deck) l.add(i);
        Collections.sort(l);
        int ptr = 0;
        
        // for filling even position
        while(ptr < deck.length)
        {
            d[ptr] = l.get(0);
            l.remove(0);
            ptr += 2;
        }
        
        // if there has length is 1 then you dont have to go for odd position
        if(deck.length == 1) return d;
        
        if(deck.length % 2 == 0) 
        {
            d[1] = l.get(0);
            l.remove(0);   
        }
        ptr = 1;
        int blank = 0;
        
        // for filling odd position
        while(l.size() != 0)
        {
            if(d[ptr] == 0) blank++;
            if(blank == 2) 
            {
                d[ptr] = l.get(0);
                l.remove(0);
                blank = 0;
            }
            ptr += 2; 
            if(ptr >= d.length) ptr = 1;
        }
        return d;
    }
}
