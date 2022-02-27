class Solution {
    public boolean isHappy(int n) {
        
        boolean isHappy = true;
        
        HashMap<Integer, Integer> frequencies = new HashMap<>();
        
        
        
        while(n != 1) {
            if(frequencies.get(n) != null) {
                isHappy = false; 
                break;
            }
            
            frequencies.put(n, 1);
            
            int newValue = 0;
            int curValue = n;
            
            while(curValue != 0) {
                newValue += (curValue % 10) * (curValue % 10);
                curValue = curValue / 10;
            }
            
            n = newValue;
        }
    
        
        
        return isHappy;
    }
}