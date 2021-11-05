class Solution {
    public int reverse(int x) {
         boolean isNegative = false;
         if(x < 0) {
             isNegative = true;
             x = -1 * x;
         }
        
        long reversedInt = 0;
        
        while(true) {
            if(x <= 0) {
                break;
            }
            reversedInt *= 10;
            reversedInt += x % 10;
            x = x / 10;
        }
        
        if(reversedInt > Integer.MAX_VALUE) {
            reversedInt = 0;
        }
        
        return (int) (isNegative ? reversedInt * -1 : reversedInt);
    }
}