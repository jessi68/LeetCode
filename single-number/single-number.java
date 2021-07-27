class Solution {
    public int singleNumber(int[] nums) {
        int answer = -1;
        Arrays.sort(nums);
        int previousNumber = -1111111;
        int i = 0;
        
        if(nums.length == 1) {
            return nums[0];
        }
        
        while(i < nums.length) {
            if(i != 0 && previousNumber != nums[i]) {
                answer = previousNumber;
                break;
            } else if(previousNumber == nums[i]) {
                if(i == nums.length - 2)  {
                    answer = nums[i + 1];
                    break;
                } else{
                    i++;
                }
                previousNumber = nums[i];
                i++;
            } else{
                previousNumber = nums[i];
                 i++;
            }
        }
        
        if(answer == -1111111)  {
            answer = previousNumber;
        }
      
        return answer;
    }
}