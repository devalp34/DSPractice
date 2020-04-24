class LRUCache {
    HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
    List<Integer> l = new LinkedList<Integer>();
    int size = 0, len = 0;
    
    public LRUCache(int capacity) {
        size = capacity;
    }
    
    public int get(int key) {
        int ans = 0;
        if(!hm.containsKey(key)) return -1;
        else 
        {
            ans = hm.get(key);
            l.remove(l.indexOf(key));
            l.add(0,key);
        }
        return ans;
    }
    
    public void put(int key, int value) {
        if(!hm.containsKey(key))
        {
            hm.put(key,value);
            l.add(0,key);
            len++;
            if(len > size)
            {
                hm.remove(l.get(len-1));
                len--;   
            }
        }
        else
        {
            hm.put(key,value);
            l.remove(l.indexOf(key));
            l.add(0,key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
