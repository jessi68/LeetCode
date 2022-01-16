class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxValue = 0;
        int i = 0;
        Stack<Integer> stack = new Stack<Integer>();
        int length = heights.length;
        
        while (i <= length) {
        	int no = i == length ? 0 : heights[i];
            if (stack.isEmpty() || no >= heights[stack.peek()]) {
            	stack.push(i);
            	i++;
            } else {
            	int h = heights[stack.pop()];
            	int w = stack.isEmpty()? i : i - 1 - stack.peek();
            	maxValue = Math.max(maxValue, h*w);
            }
        }

		return maxValue;     
    }
}