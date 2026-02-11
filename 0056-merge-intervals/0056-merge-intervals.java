class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        int j = 0;
        for(int[] interval : intervals) {
            if(intervals[j][1] >= interval[0]) intervals[j][1] = Math.max(intervals[j][1], interval[1]);
            else intervals[++j] = interval;
        }
        return Arrays.copyOfRange(intervals, 0, ++j);
    }
}