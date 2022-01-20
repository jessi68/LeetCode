class Solution {
    
    public int calculateMaxArea(int [] height) {
        int left = 0;
        int right = height.length - 1;
    
        int maxCandidateArea = -1;
        
        while(left < right) {
                                 maxCandidateArea = Math.max(maxCandidateArea, Math.min(height[left], height[right]) * (right - left));
           if(height[left] >= height[right]) {
                   right = right - 1;
                 
               
           } else {
               
                   left = left + 1;
               
               }
        }
        
        return maxCandidateArea;
        
    }
    
    public int maxArea(int[] height) {   
        return calculateMaxArea(height);
    }
}