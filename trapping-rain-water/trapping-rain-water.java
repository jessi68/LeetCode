class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int left_max = 0, right_max = 0;
        int answer = 0;
        
        
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= left_max) {
                    left_max = height[left];
                }
                else {
                    answer += left_max - height[left];
                } 
                left+= 1;
            }
            
            else {
                if (height[right] >= right_max) {
                    right_max = height[right];
                }
                else {
                    answer += right_max - height[right];
                }
                right-= 1;      
            }
        }
        return answer;
    }
}