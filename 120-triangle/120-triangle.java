class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int triangleLength = triangle.size();
        
        int [][] dp = new int[triangleLength][triangleLength];
        
        dp[0][0] = triangle.get(0).get(0);
        
        
        for(int i = 1; i < triangleLength; i++) {
            for(int j = 0; j <= i; j++) {
                if(j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                    continue;
                }
                if(j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                    continue;
                }
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
            }
        }
        
        int totalMinimum = dp[triangleLength - 1][0];
        
        for(int j = 1; j < triangleLength; j++) {
            if(totalMinimum > dp[triangleLength - 1][j]) {
                totalMinimum = dp[triangleLength - 1][j];
            }
        }
        
        return totalMinimum;
    }
}