class Solution {
    public String longestWord(String[] words) 
    {
        Arrays.sort(words, new Comparator<String>(){
            public int compare(String a, String b)
            {
                return a.length() - b.length();
            }
        });
        HashMap<Integer,List<String>> hm = new HashMap<Integer,List<String>>();
        List<String> w = Arrays.asList(words);
        HashSet<String> hs = new HashSet<String>();
        int maxLen = 0;
        for(String s : words)
        {
            if(s.length() == 1)
            {
                List<String> l = new LinkedList<String>();
                if(hm.containsKey(s.length())) l = hm.get(s.length());
                l.add(s);
                hm.put(s.length(),l);
                hs.add(s);
                if(maxLen <  s.length()) maxLen = s.length();
            }
            else
            {
                String s1 = s.substring(0,s.length()-1);
                if(w.indexOf(s1) != -1 && hs.contains(s1))
                {
                    List<String> l = new LinkedList<String>();
                    if(hm.containsKey(s.length())) l = hm.get(s.length());
                    l.add(s);
                    hm.put(s.length(),l);
                    if(maxLen <  s.length()) maxLen = s.length();
                    hs.add(s);
                }
            }
        }
        w = hm.get(maxLen);
        Collections.sort(w);
        return w.get(0);
    }
}
