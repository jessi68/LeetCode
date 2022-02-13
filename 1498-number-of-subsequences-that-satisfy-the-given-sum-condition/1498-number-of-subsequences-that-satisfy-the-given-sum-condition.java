class Solution {
    
   public int numSubseq(int[] nums, int target) {
    final int kMod = (int) (1e9 + 7);
       
    final int length = nums.length;
    int ans = 0;
     
    int[] pows = new int[length]; // pows[i] = 2^i % kMod
    pows[0] = 1;

    for (int i = 1; i < length; ++i)
      pows[i] = pows[i - 1] * 2 % kMod;

    Arrays.sort(nums);

    for (int left = 0, right = length - 1; left <= right;)
      if (nums[left] + nums[right] <= target) {
        ans = (ans + pows[right - left]) % kMod;
        left = left + 1;
      } else {
        right = right - 1;
      }

    return ans;
  }
}