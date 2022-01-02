class Solution {
    public int maxSubArray(int[] nums) {
 int b=0;
         int c=-2147483648;
        
        for(int i=0; i < nums.length; i++){
            b=Math.max(b+nums[i],nums[i]);
            c = c>b?c:b;
        }
        return c;
    }
        
    }
