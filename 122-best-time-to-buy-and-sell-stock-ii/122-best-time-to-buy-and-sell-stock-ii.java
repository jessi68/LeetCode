class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int currentPrice = -1;
        
        
        for(int i = 0; i < prices.length; i++) {
            
            if(currentPrice >= 0) {
                if(prices[i] > currentPrice) {
                    profit += prices[i] - currentPrice;
                }
                
                currentPrice = -1;
            } 
            
          
            currentPrice = prices[i];
        }
        
        return profit;
    }
}