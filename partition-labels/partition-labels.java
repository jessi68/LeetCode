class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> answers = new ArrayList<>();
       

        HashMap<Character, Integer> characterToMaxIndex = new HashMap<>();
        int length = s.length();

        for(int index = 0; index < length; index++) {
             if (characterToMaxIndex.containsKey(s.charAt(index))) {
                 characterToMaxIndex.put(s.charAt(index), index);
             } else{
                 characterToMaxIndex.put(s.charAt(index), index);
             }
        }

       
        int start = 0;
        int prev = 0;
        int possibleMinIndex = 0;

        while(start < length) {
            int curMaxIndex = characterToMaxIndex.get(s.charAt(start));

            if(possibleMinIndex < curMaxIndex) {
                possibleMinIndex = curMaxIndex;
            }

            if(possibleMinIndex == start) {
                answers.add(start + 1 - prev);
                prev = start + 1;
            }
            start += 1;
        }
        return answers;
    }
}