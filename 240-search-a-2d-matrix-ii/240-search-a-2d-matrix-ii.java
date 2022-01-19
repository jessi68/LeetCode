class Solution {
    int [][] matrix;
    int target;
    
    public boolean searchMatrix(int[][] matrix, int target) {
        this.matrix = matrix;
        this.target = target;
        return divideConquer(0, 0, matrix[0].length, matrix.length);
    }
    
    private boolean isTargetFound(boolean a, boolean b, boolean c, boolean d) {
        if(a || b || c || d) {
            return true;
        } 
        return false;
    }
    
    private boolean isExistRectangle(int xLength, int yLength) {
        return !(xLength == 0 ||  yLength == 0);
    }
    
    private boolean isUndividableRectangle(int xLength, int yLength) {
        return xLength == 1 && yLength == 1;
    }
    
    private boolean divideConquer(int startY, int startX, int xLength, int yLength) {
        if(!isExistRectangle(xLength, yLength)) {
            return false;
        }
        
        if(isUndividableRectangle(xLength, yLength)) {
            return matrix[startY][startX] == target;
        }
        
        int halfLengthX = xLength / 2;
        int halfLengthY = yLength / 2;

        
        boolean leftTopAscending = divideConquer(startY, startX, halfLengthX, halfLengthY);
        boolean rightTopAscending = divideConquer(startY, startX + halfLengthX, xLength - halfLengthX, halfLengthY);

        boolean leftBottomAscending = divideConquer(startY + halfLengthY, startX, halfLengthX, yLength - halfLengthY);
        boolean rightBottomAscending = divideConquer(startY + halfLengthY, startX + halfLengthX, xLength - halfLengthX, yLength - halfLengthY);
        
        if(isTargetFound(leftTopAscending, rightTopAscending, leftBottomAscending, rightBottomAscending)) {
            return true;
        }
        
      
        return false;
        
        
    }
}