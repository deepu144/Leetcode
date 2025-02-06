class Solution {
    public static int INF=Integer.MAX_VALUE;
    public int[] countOfPairs(int n, int x, int y) {
        int[][] mat=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(mat[i],INF);
            mat[i][i]=0;
            if(i-1>=0) mat[i][i-1]=1;
            if(i+1<n) mat[i][i+1]=1; 
        }
        if(x!=y) mat[x-1][y-1]=mat[y-1][x-1]=1;
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                if(mat[i][k]==INF) continue;
                for(int j=0;j<n;j++){
                    if(mat[k][j]==INF) continue;
                    mat[i][j]=Math.min(mat[i][j],mat[i][k]+mat[k][j]);
                }
            }
        }
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]!=0) res[mat[i][j]-1]++;
            }
        }
        return res;
    }
}