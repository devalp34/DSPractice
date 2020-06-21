class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        
        List<Integer> ans = new LinkedList<Integer>();
        int len = restaurants.length;
        List<Integer> l = new LinkedList<Integer>();
        
        
        for(int i = 0 ; i < len ; i++)
        {
            int[] r = restaurants[i];
            if(veganFriendly == 1)
            {
                if(r[2] == 1 && r[3] <= maxPrice && r[4] <= maxDistance) 
                    ans.add(i);
            }
            else if(r[3] <= maxPrice && r[4] <= maxDistance) ans.add(i);
        }
    
        Collections.sort(ans,((e1,e2) -> restaurants[e1][1] == restaurants[e2][1] ? restaurants[e2][0] - restaurants[e1][0] : restaurants[e2][1] - restaurants[e1][1]));
            
        
        for(int i : ans) l.add(restaurants[i][0]);
        
        return l;
    }
}
