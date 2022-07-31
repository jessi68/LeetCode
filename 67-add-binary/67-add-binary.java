class Solution {
    public String addBinary(String a, String b) {
     
        String result = "";
        
        if (a.length() > b.length()) {
            String temp = a;
            a = b; 
            b = temp;
        }
     
        // aLength <= bLength
        
        int roundUp = 0;
        int aLength = a.length();
        int bLength = b.length();
        
        int currentValue = 0;
        
        for(int i = 0; i < aLength; i++) {
            currentValue = roundUp;
            currentValue += Character.getNumericValue(a.charAt(aLength - 1 - i)) + Character.getNumericValue(b.charAt(bLength -1 - i));
            if(currentValue >= 2) {
                roundUp = 1;
                currentValue -= 2;
            } else {
                roundUp = 0;
            }
            result = String.valueOf(currentValue) + result; 
            
        }
        
        for(int i = aLength; i < bLength; i++) {
            currentValue = roundUp;
            currentValue += Character.getNumericValue(b.charAt(bLength -1 - i));
            if(currentValue >= 2) {
                roundUp = 1;
                currentValue -= 2;
            } else{
                roundUp = 0;
            }
            result = String.valueOf(currentValue) + result; 
        }
        
        if(roundUp != 0) {
            result = "1" + result;
        }
        
        return result;
    }
}