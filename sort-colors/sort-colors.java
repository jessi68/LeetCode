class Solution {
    public void sortColors(int[] nums) {
        HashMap<Integer, Integer> colorToCount = new HashMap<>();
        
        for(int num: nums) {
            if(colorToCount.containsKey(num)) {
                colorToCount.put(num, colorToCount.get(num) + 1);
            } else{
                colorToCount.put(num, 1);
            }
        }
        int length = nums.length;
        
        
        int curCount;
        int start = 0;
        for(int color = 0; color < 3; color++) {
            if(!colorToCount.containsKey(color))  {
                continue;
            }
            curCount = colorToCount.get(color);
            for(int j = 0; j < curCount; j++) {
                nums[start] = color;
                start++;
            }
        }
        
        
    }
}