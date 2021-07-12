class Solution {
    
    public int numberOf1(int decimal) {
        int count = 0;
        while(true) {
            if(decimal < 2) {
                if(decimal == 1) {
                    count += 1;
                }
                break;
            }
            count += (decimal % 2);
            decimal = decimal / 2;
                
        }
        return count;
    }
    
    public int[] countBits(int n) {
        int[] answer = new int[n + 1];
        
        for(int i = 0; i <= n; i++) {
            answer[i] = numberOf1(i);
        }
        
        return answer;
    }
}