class Solution {
     
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
		dp[0] = 1;
        for(int i = 1; i <= n; i++) {
            
            for(int r = 1; r <= i; r++) {
            // 왼쪽 트리 노드 개수는 루트의 값에 따라 달라짐, 
            // 오른쪽 트리 노드 개수 마찬가지. 
            dp[i]+= dp[r - 1] * dp[i - r];
            }
        }
        return dp[n];
    }
    
   
}