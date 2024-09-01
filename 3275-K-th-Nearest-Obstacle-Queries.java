class Solution {
    public int[] resultsArray(int[][] q, int k) {
        int n = q.length, j = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int[] arr = new int[n];
        for (int[] a : q) {
            int dist = Math.abs(a[0]) + Math.abs(a[1]);
            if (pq.size() < k) {
                pq.offer(dist);
            } else if (dist < pq.peek()) {
                pq.poll();
                pq.offer(dist);
            }
            if (pq.size() == k) {
                arr[j++] = pq.peek();
            } else {
                arr[j++] = -1;
            }
        }
        return arr;
    }
}
