class Solution {
    int [][] newGridArray;
    public int minPathSum(int[][] grid) {
        
        newGridArray = new int[grid.length][grid[0].length];
        for(int x = 0; x < newGridArray.length; x+= 1) 
            for (int y = 0; y < newGridArray[x].length; y+= 1) {
                newGridArray[x][y] = Integer.MAX_VALUE;
            }
        findMin(grid, newGridArray, 0, 0, 0);
        return newGridArray[newGridArray.length - 1][newGridArray[0].length - 1];
    }
    
    public void findMin(int[][] grid, int[][] newGrid, int sum, int x, int y) {
        if (sum + grid[x][y] >= newGridArray[x][y]) {
            return;
        }
        newGrid[x][y] = sum + grid[x][y];
        sum = newGridArray[x][y];
        if (y < grid[0].length - 1) {
            findMin(grid, newGridArray, sum, x, y + 1);
        }
        if (x < grid.length - 1) {
            findMin(grid, newGridArray, sum, x + 1, y);
        }
    }
}