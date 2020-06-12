class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int profit = 0, purchase = prices[0];
    
        for(int i = 1 ; i < prices.length ; i++)
        {
            if(purchase > prices[i]) purchase = prices[i];
            else profit = Math.max(profit, prices[i] - purchase);
        }
        
        return profit;
    }
}
