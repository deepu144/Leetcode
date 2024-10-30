class Solution {
    final int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};
    public int longestIncreasingPath(int[][] mat) {
        int res=-1,m=mat.length,n=mat[0].length;
        Integer[][] dp=new Integer[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                res=Math.max(res,path(mat,m,n,i,j,-1,dp));
            }
        }
        return res==-1?1:res;
    }
    public int path(int[][] mat,int m,int n,int i,int j,int prev,Integer[][] dp){
        if(i<0||j<0||i>=m||j>=n||mat[i][j]==-1||prev>=mat[i][j]) return 0;
        if(dp[i][j]!=null) return dp[i][j];
        int max=0;
        int t=mat[i][j];
        mat[i][j]=-1;
        for(final int[] a : dir){
            max=Math.max(max,1+path(mat,m,n,a[0]+i,a[1]+j,t,dp));
        }
        mat[i][j]=t;
        return dp[i][j]=max;
    }
}