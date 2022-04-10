class Solution {
  ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
  int [] nums;
 
  public void cleanDeque(int i, int k) {
    if (!deq.isEmpty() && deq.getFirst() == i - k)
      deq.removeFirst();
 
 
    while (!deq.isEmpty() && nums[i] > nums[deq.getLast()]){
		deq.removeLast();
	}
  }
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        
       
        if (k == 1) return nums;

        this.nums = nums;
        
        int maxIndex = 0;
        for (int i = 0; i < k; i++) {
          cleanDeque(i, k);
          deq.addLast(i);
          if (nums[i] > nums[maxIndex]) maxIndex = i;
        }
        
        int [] results = new int[n - k + 1];
        results[0] = nums[maxIndex];

        for (int i = k; i < n; i++) {
          cleanDeque(i, k);
          deq.addLast(i);
          results[i - k + 1] = nums[deq.getFirst()];
        }
        
        return results;
        
    }
}