class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        TreeMap<Integer, Integer> pq = new TreeMap();
        HashMap<Integer, Integer> result = new HashMap<>();
        int index = 0;
        int  length =  intervals.length;
        int queryLength = queries.length;
        int[] totalResults = new int[queryLength];
        int[] queriesClone = queries.clone();
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(queriesClone);
        
        for(int q: queriesClone) {
            while(index < length && intervals[index][0] <= q) {
                int l = intervals[index][0];
                int r = intervals[index][1];
                index += 1;
                pq.put(r - l + 1, r);
            }
            
            while(!pq.isEmpty() && pq.firstEntry().getValue() < q) {
                pq.pollFirstEntry();
            }
            
            result.put(q, pq.isEmpty() ? -1 : pq.firstKey());
        }
        index = 0;
        for (int q: queries) {
            totalResults[index] = result.get(q);
            index+= 1;
        }
        
        return totalResults;
    }
}