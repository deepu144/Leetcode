class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        int maxEnd=0,cover=0;
        for(int[] a : intervals){
            if(a[1]>maxEnd){
                maxEnd=a[1];
                cover++;
            }
        }
        return cover;
    }
}