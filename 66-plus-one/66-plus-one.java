class Solution {
    public int[] plusOne(int[] digits) {
    int n = digits.length;
        
    int[] newDigits = new int[n + 1];
        
    for(int i = n - 1; i >= 0; i--) {
        digits[i]+= 1;
        if(digits[i] > 9) {
            digits[i] = 0;
        } else {
            return digits;
        }
    }
        
    newDigits[0] = 1;
        
    return newDigits;
    
    }
}