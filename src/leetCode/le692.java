class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> hm = new HashMap<>();
        for(String s : words) hm.put(s,hm.getOrDefault(s,0)+1);
        
        HashMap<Integer,List<String>> hm1 = new HashMap<>();
        for(String s : hm.keySet())
        {
            hm1.computeIfAbsent(hm.get(s),e -> new LinkedList<String>());
            List<String> l = hm1.get(hm.get(s));
            l.add(s);
            hm1.put(hm.get(s),l);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((e1,e2)->e2-e1);
        
        for(int i : hm1.keySet())
        {
            pq.add(i);
        }
        
        List<String> l = new LinkedList<String>();
        
        while(l.size() < k)
        {
            List<String> l1 = hm1.get(pq.poll());
            Collections.sort(l1);
            if(l1.size() <= k - l.size()) l.addAll(l1);
            else l.addAll(l1.subList(0,(k-l.size())));
        }
        
        return l; 
    }
}
