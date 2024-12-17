class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)->Integer.compare(a[1],b[1]));
        int res=1,end=points[0][1],n=points.length;
        for(int i=1;i<n;i++){
            if(end<points[i][0]){
                res++;
                end=points[i][1];
            }
        }
        return res;
    }
}