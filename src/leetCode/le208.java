class Trie {

    /** Initialize your data structure here. */
    class trieNode
    {
        HashMap<Character,trieNode> hm = new HashMap<>();;
        boolean eow = false;
    }
    
    trieNode root = null;
    
    public Trie() {
        root = new trieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        trieNode current = root;
        for(char c : word.toCharArray())
        {
            trieNode ptr = current.hm.get(c);
            if(ptr == null)
            {
                ptr = new trieNode();
                current.hm.put(c,ptr);
            }
            current = ptr;
        }
        current.eow = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        trieNode current = root;
        for(char c : word.toCharArray())
        {
            if(!current.hm.containsKey(c)) return false;
            else current = current.hm.get(c);
        }
        return current.eow;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        trieNode curr = root;
        for(char c : prefix.toCharArray())
        {
            if(curr.hm.containsKey(c)) curr = curr.hm.get(c);
            else return false;
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
