class Solution {
    public int maximalSquare(char[][] matrix) {
        
    
        int rowNumbers = matrix.length;
        int colNumbers = matrix[0].length;
        
        int[][] dp = new int[rowNumbers + 1][colNumbers + 1];
        int maxlength = 0;

        for (int i = 1; i <= rowNumbers; i++) {
            for (int j = 1; j <= colNumbers; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    maxlength = Math.max(dp[i][j], maxlength);
                } else {
                    dp[i][j] = 0;	
                }
            }
        }

        return maxlength * maxlength;
    }
}