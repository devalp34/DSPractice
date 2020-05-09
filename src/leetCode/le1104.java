class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);
        int i = 1;
        while((Math.pow(2,i) + hm.get(i-1)) < label)
        {
            hm.put(i,(int) Math.pow(2,i)+hm.get(i-1));
            i++;
        }
        hm.put(i,(int) Math.pow(2,i)+hm.get(i-1));
        int row = i + 1, node = -1;
        if(row % 2 == 0) node = hm.get(i) - label + 1;
        else node = label - hm.get(i-1);
        List<Integer> l = new LinkedList<Integer>();
        l.add(label);
        if(label == 1) return l;
        while(row > 2)
        {
            row -= 1;
            if(node % 2 == 0) node /= 2;
            else node = (node/2) + 1;
            if(row % 2 == 0) l.add(0,hm.get(row - 1) - node + 1);
            else l.add(0,hm.get(row - 2) + node);
        }
        l.add(0,1);
        return l;
    }
}
