class Solution {
public:
    int minEatingSpeed(vector<int>& piles, int h) {
        int length = piles.size();
        int quotient = h / length;
        int remainder = h % length;
        int minBanana = 0;
        int currentBanana;
        
        
        sort(piles.begin(), piles.end());
        
        int start = 1; 
        int end = piles[length - 1];
        
        while(start < end) {
            int speed = (start + end) / 2; 
            cout << speed << " speed" << endl;
            int time = 0; 
            
            for(int i = 0; i < length; i++) {
                
                time += ceil((double) piles[i] / speed);
                if(time > h) {
                    start = speed + 1;
                    break;
                }
            }
        
            
            if(time <= h) {
                end = speed;
            }
            
            
        }
        
        cout << start << endl;
        cout << end << endl;
    
        return start;
        
    }
};