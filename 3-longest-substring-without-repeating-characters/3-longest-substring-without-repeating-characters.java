class Solution {
    
     public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
         
        int start =0;
        int end = 0;
         
        int length = s.length();
         
        HashSet<Character> strSet = new HashSet<>();

        while (end < length) {
            if(start > end) break;
            if (!strSet.contains(s.charAt(end))){
                strSet.add(s.charAt(end));
                end++;
                maxLength = Math.max(maxLength, end - start);
                continue;
            }
            strSet.remove(s.charAt(start));
            start++;

        }

        return maxLength;
    }
}