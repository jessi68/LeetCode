class Solution {
    int [] stairs;
    public int climbStairs(int n) {
        stairs = new int[n + 1];
        stairs[0] = 1;
        stairs[1] = 1;
      
        for(int i = 2; i <= n; i++) {
            calculateStairMethodNum(i);
        }
        
        return stairs[n];
    }
    
    public void calculateStairMethodNum(int i) {
        stairs[i] = stairs[i - 1] + stairs[i - 2];
    }
}