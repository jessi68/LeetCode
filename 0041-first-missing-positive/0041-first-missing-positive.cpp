
class Solution {
public:
    int firstMissingPositive(vector<int>& nums) {
        unordered_map<int, int> hash_map;
        
        
        for(auto num: nums) {
            hash_map[num] = 1;
        }
        
        int answer = 1; 
        
        while(true) {
            if(hash_map.find(answer) == hash_map.end()) {
                return answer;
            } else {
                answer += 1;
            }
        }
        
    
        return answer;
    }
};