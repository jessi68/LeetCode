class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
		int majorityElem = 0;
		for (int n : nums) {
			if (count == 0) {
				majorityElem = n;
			}
			if (n == majorityElem) {
				count+= 1;
			} else {
				count-=1;
			}
		}

		return majorityElem;
    }
}