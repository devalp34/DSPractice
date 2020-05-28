class Solution {
    ArrayList<Integer>[] graph;
    ArrayList<Integer>[] time;
    public int networkDelayTime(int[][] times, int N, int K) {
      
        graph = new ArrayList[N+1];
        time = new ArrayList[N+1];
        
        for(int i = 1 ; i <= N ; i++)
        {
            graph[i] = new ArrayList<Integer>();
            time[i] = new ArrayList<Integer>();
        }
        
        for(int[] t : times)
        {
            graph[t[0]].add(t[1]);
            time[t[0]].add(t[2]);
        }
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        Queue<Integer> q = new LinkedList<Integer>();
        List<Integer> l = new LinkedList<Integer>();
        q.add(K);
        hm.put(K,0);
        int ptr = 0, currTime = 0, curr = 0;
        
        while(q.size() != 0)
        {
            curr = q.poll();
            currTime = hm.get(curr);
            ArrayList<Integer> a = graph[curr];
            for(int i : a)
            {
        if(!hm.containsKey(i) || hm.get(i) > time[curr].get(ptr) + currTime)
                {
                    if(!q.contains(i))l.add(i);
                    hm.put(i,time[curr].get(ptr++) + currTime);
                }
                else ptr++;
            }
            ptr = 0;
            if(q.size() == 0) 
            {
                while(l.size() > 0) 
                {
                    q.add(l.get(0));
                    l.remove(0);
                }
            }
        }
        if(hm.size() != N) return -1;
        int delay = 0;
        
        for(int i = 1 ; i <= N ; i++) delay = Math.max(delay,hm.get(i));
        return delay;
    }
}
