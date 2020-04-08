class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        for(int i = 0 ; i < words.length - 1 ; i++)
        {
            String s1 = words[i];
            String s2 = words[i+1];
            
            int k = 0, j = 0;
            while(k < s1.length() || j < s2.length())
            {
                int ai = 0, bi = 0;
                if(k == s1.length() || j == s2.length())
                        return false;
                    ai = order.indexOf(s1.charAt(k));
                    bi = order.indexOf(s2.charAt(j));    
                
                if(ai == bi) 
                {
                    k++;
                    j++;
                }
                else if(ai < bi) break;
                else return false;
            }
        }
        return true;
    }
}
