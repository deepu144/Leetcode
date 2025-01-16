class Solution {
    public int maxPoints(int[][] points) {
        int n=points.length,max=2;
        if(n<=2) return n;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int count=2;
                for(int k=0;k<n && k!=i && k!=j;k++){
                    if((points[j][1]-points[i][1])*(points[k][0]-points[i][0]) == (points[k][1]-points[i][1])*(points[j][0]-points[i][0])) count++;
                }
                max=Math.max(max,count);
            }
        }
        return max;
    }
}