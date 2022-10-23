#include <cmath>

class Solution {
public:
    int numSquares(int n) {
        int * dp = new int[n + 1];
        dp[1] = 1; 
        dp[0] = 0;
        
        int rootMaxValue; 
        
        for(int i = 2; i <= n; i++) {
            dp[i] = i; 
            rootMaxValue = pow(i, 0.5);
            for(int value = 1; value <= rootMaxValue; value++) {
                if(dp[i] > 1 + dp[i - value * value]) {
                    dp[i]  = 1+ dp[i - value * value];
                }
            }
        }
        
        return dp[n];
    }
};