class Solution {
    HashSet<String> hs = new HashSet<String>();
    int size = 0;
    public int numTilePossibilities(String tiles) {
        StringBuilder sb = new StringBuilder("");
        boolean[] v = new boolean[tiles.length()];
        
        for(size = 1 ; size <= tiles.length() ; size++)
        {
            bt(tiles,v,sb);
        }
        return hs.size();
    }
    
    void bt(String t, boolean[] v, StringBuilder sb)
    {
        if(sb.length() == size)
        {
            hs.add(sb.toString());
            return;
        }
        for(int i = 0 ; i < t.length() ; i++)
        {
            if(v[i]) continue;
            v[i] = true;
            sb.append(t.charAt(i));
            bt(t,v,sb);
            sb.delete(sb.length()-1,sb.length());
            v[i] = false;
        }
    }
}
