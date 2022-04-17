class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) {
            return 0;
        }
        
        int [] minNum = new int[amount + 1];
        
        for(int i = 1; i <= amount; i++) {
            minNum[i] = Integer.MAX_VALUE;
            
            for(int j = 0; j < coins.length; j++)  {
                if(coins[j] <= i) {
                    if(minNum[i - coins[j]] != Integer.MAX_VALUE) {
                        minNum[i] = Integer.min(minNum[i], 1 + minNum[i - coins[j]]);
                    }
                }
            }
        }
        
        if(minNum[amount] == Integer.MAX_VALUE) {
            return -1;
        }
        return minNum[amount];
    }
}