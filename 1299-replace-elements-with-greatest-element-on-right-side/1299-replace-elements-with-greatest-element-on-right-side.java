import java.util.Arrays;
import java.util.Collections;



class Solution {
    
  
    
    public int[] replaceElements(int[] arr) {
        int length = arr.length;
        // int maxValue = Arrays.stream(Arrays.copyOfRange(arr, 1, length)).max().getAsInt();
        int maxValue = -1;
        int temp;
     
        for(int i = length - 1; i >= 0; i--) {
            temp = arr[i];
            arr[i] = maxValue;
            maxValue = Math.max(maxValue, temp);
        }
        
        return arr;
        
        
    }
}