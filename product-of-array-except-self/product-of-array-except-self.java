class Solution {
    public int[] productExceptSelf(int[] nums) {
         int[] results = new int[nums.length];
        results[0] = 1;
        for (int i = 1; i < nums.length; i++) {
          results[i] = results[i - 1] * nums[i - 1];
        }
        int previous_num = 1;
        for (int j = nums.length - 2; j >= 0; j--) {
          previous_num *= nums[j + 1];
          results[j] *= previous_num;
        }
        return results;
    }
}