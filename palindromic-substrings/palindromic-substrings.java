class Solution {
    
    int isPalindrome[][];
    String target;
    
    void findPalindrome(int start, int end) {
        if(isPalindrome[start][end] != -1) {
            return;
        }
        if(end - start == 1) {
            isPalindrome[start][end] = target.charAt(start) == target.charAt(end) ? 1 : 0;
        } else{
            
            if(isPalindrome[start + 1][end - 1] == -1) {
                findPalindrome(start + 1, end - 1);
            }
            if(isPalindrome[start + 1][end - 1] == 0) {
                isPalindrome[start][end] = 0;
            } else{
                isPalindrome[start][end] = target.charAt(start) == target.charAt(end) ? 1 : 0;
            }
        }
    }
    
    public int countSubstrings(String s) {
       int length = s.length();
        target = s;
        
       isPalindrome = new int[length][length];
       for(int i = 0; i < length; i++) {
           for(int j = 0; j < length; j++) {
               if(i == j) {
                   isPalindrome[i][j] = 1;
               } else{
                isPalindrome[i][j] = -1;
               }
           }
       }
        int result = 0;
        
        for(int i = 0; i < length; i++) {
           for(int j = i; j < length; j++) {
               if(isPalindrome[i][j] == -1) {
                    findPalindrome(i, j);
               }
               result += isPalindrome[i][j];
           }
       }
        
        return result;
       
    }
    
}