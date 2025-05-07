class Solution {
    final int INF=Integer.MAX_VALUE;
    final int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int minTimeToReach(int[][] moveTime) {
        int r = moveTime.length, c = moveTime[0].length;
        int[][] dist = new int[r][c];
        for (int[] a : dist) Arrays.fill(a, INF);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0, 0, 0});
        moveTime[0][0] = 0;
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int currTime = p[0];
            int currRow = p[1];
            int currCol = p[2];
            if (currTime >= dist[currRow][currCol]) continue;
            if (currRow == r - 1 && currCol == c - 1) return currTime;
            dist[currRow][currCol] = currTime;
            for (int[] a : dir) {
                int x = currRow + a[0];
                int y = currCol + a[1];
                if(x<0 || y<0 || x>=r || y>=c || dist[x][y]!=INF) continue;
                int nextTime = Math.max(moveTime[x][y], currTime) + 1;
                pq.add(new int[]{nextTime, x, y});
            }
        }
        return -1;
    }
}