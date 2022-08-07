class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] engineersInfo = new int[n][2];
        for (int i = 0; i < n; i++) {
            engineersInfo[i] = new int[]{efficiency[i], speed[i]};
        }
        
        Arrays.sort(engineersInfo, (a, b) -> Integer.compare(b[0], a[0]));
        
        long result = 0;
        long speedSum = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue();
        
        for (int[] engineerInfo : engineersInfo) {
            speedSum += engineerInfo[1];
            result = Math.max(result, speedSum * engineerInfo[0]);
            pq.add(engineerInfo[1]);
            if (pq.size() >= k) speedSum -= pq.poll();
        }
        return (int) (result % (long)(1e9 + 7));
    }
}