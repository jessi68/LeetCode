class Solution {
    
    public int[] twoSum(int[] numbers, int target) {
        int[] answers = new int[2];
        
        if (numbers == null || numbers.length <= 1) {
        	return answers;
        }
        
        int start = 0;
        int end = numbers.length - 1;
        while(start < end) {
        	long sum = (long)(numbers[start] + numbers[end]);
        	if (target == sum) {
        	answers[0] = start + 1;
        	answers[1] = end + 1;
        		break;
        	} else if (target > sum) {
        		start++;
        	} else {
        		end--;
        	}
        }
        return answers;
    }
}