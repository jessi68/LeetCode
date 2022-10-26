class Solution {
public:
    int combinationSum4(vector<int>& nums, int target) {
        vector<unsigned int> combinationSum;
        int length = nums.size();
        
        for(int i = 0; i <=  target; i++) {
            combinationSum.push_back(0);
        }
        combinationSum[0] = 1;
        
        sort(nums.begin(), nums.end());
        
        int index = 0;
        
        for(long curNum = 1; curNum <= target; curNum++) {
            index = 0;
            while(index < length && nums[index] <= curNum) {
                combinationSum[curNum] += combinationSum[curNum - nums[index]];
                index += 1;
            }
        }
            
        return combinationSum[target];
    }
};