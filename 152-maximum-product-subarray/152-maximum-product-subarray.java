class Solution {
    public int maxProduct(int[] nums) {
     
        int n = nums.length;
        int result = nums[0];
        int min = nums[0];
        int max = nums[0];

        for(int i = 1; i < n; i++){
        	int temp = max;
        	max = Math.max(max * nums[i], Math.max(min * nums[i], nums[i]));
        	min = Math.min(temp * nums[i], Math.min(min * nums[i], nums[i]));
        	result = Math.max(max, result);
        }

        return result;
    }
}