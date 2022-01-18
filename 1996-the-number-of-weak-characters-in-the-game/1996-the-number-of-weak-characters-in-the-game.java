
class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        
        Arrays.sort(properties, (int[] a, int[] b) -> a[0] == b[0] ? (a[1] - b[1]) : -(a[0] - b[0]));
        
        int maxElement = 0;
        int maxFirstElement = properties[0][0];
        int answer = 0;
        
        for(int i = 0; i < properties.length; i++) {
            if(properties[i][1] < maxElement) {
             
                answer++;
            }
            
        
              maxElement = Math.max(maxElement,  properties[i][1]);
        }
        
        return answer;
    }
    
}