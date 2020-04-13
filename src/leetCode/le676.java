class MagicDictionary {

    /** Initialize your data structure here. */
    List<String> l = new LinkedList<String>();
    public MagicDictionary() {
        
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        Arrays.sort(dict);
        for(String s : dict) l.add(s);
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        for(String s : l)
        {
            if(s.length() < word.length()) continue;
            if(s.length() == word.length())
            {
                int count = 0;
                for(int i = 0 ; i < s.length() ; i++)
                {
                    if(count > 1) break;
                    if(s.charAt(i) == word.charAt(i)) continue;
                    else count++;
                }
                if(count == 1) return true;
            }
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */
