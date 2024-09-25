class Solution {
    public int findTheCity(int n, int[][] edges, int dt) {
        int[][] mat = new int[n][n];
        for(int i=0;i<n;i++) Arrays.fill(mat[i],Integer.MAX_VALUE);    
        for(int[] a : edges){
            mat[a[0]][a[1]]=a[2];
            mat[a[1]][a[0]]=a[2];
        }
        for(int i=0;i<n;i++) mat[i][i]=0;
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(mat[i][k]==Integer.MAX_VALUE || mat[k][j]==Integer.MAX_VALUE) continue;
                    mat[i][j]=Math.min(mat[i][k]+mat[k][j],mat[i][j]);
                }
            }
        }
        int cntCity=n;
        int city=-1;
        for(int i=0;i<n;i++){
            int cnt=0;
            for(int j=0;j<n;j++){
                if(mat[i][j]<=dt) cnt++;
            }
            if(cnt<=cntCity){
                cntCity=cnt;
                city=i;
            }
        }
        return city;
    }
}