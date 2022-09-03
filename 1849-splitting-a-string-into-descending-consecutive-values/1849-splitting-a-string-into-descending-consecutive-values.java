class Solution {
    String s;
    int length;
    public boolean splitString(String s) {
        this.s = s;
        this.length = s.length();
        Long i = 0L;
        return isPossibleToSplitDescendingOrder(0, i);
    }
    
    private boolean isPossibleToSplitDescendingOrder(int startIndex, Long previous) {
        Long current = 0L;
        for(int i = startIndex; i < this.length; i++) {
            current = 10 * current + Character.getNumericValue(s.charAt(i));
            if(startIndex == 0) {
                boolean value = isPossibleToSplitDescendingOrder(i + 1, current);
                if(value == true) {
                    return true;
                }
            } else {
                System.out.println(current);
                if(previous == current + 1) {
                    System.out.println(previous);
                
                    if(i == this.length - 1) {
                     
                        return true;
                    }
                     boolean value = isPossibleToSplitDescendingOrder(i + 1, current);
                    if(value == true) {
                        return true;
                    }
                } 
            }
            
        }
        
        return false;
    }
}