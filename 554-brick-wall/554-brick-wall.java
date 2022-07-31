class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        int maxNumber = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int x = 0;
        int rowSize;
        
        for (List<Integer> row : wall) {
            x = 0;
            rowSize = row.size();
            for (int i = 0; i < rowSize - 1; i++) {
                x += row.get(i);
                map.putIfAbsent(x, 0);
                map.put(x, map.get(x) + 1);
                maxNumber = Math.max(maxNumber, map.get(x));
            }
        }
        return wall.size() - maxNumber;
    }
} 