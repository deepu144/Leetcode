class Solution {
    public final int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};
    public int countSubIslands(int[][] mat1, int[][] mat2) {
        int m=mat1.length,n=mat1[0].length;
        int subIsland=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat2[i][j]==1 && mat1[i][j]==1){
                    if(dfs(mat1,mat2,i,j,m,n)) subIsland++;
                }
            }
        }
        return subIsland;
    }
    public boolean dfs(int[][] mat1,int[][] mat,int i,int j,int m,int n){
        mat[i][j]=2;
        boolean res=true;
        res&=!(mat1[i][j]==0);
        for(final int[] a : dir){
            final int x=a[0]+i;
            final int y=a[1]+j;
            if(x<0||y<0||x>=m||y>=n||mat[x][y]==2||mat[x][y]==0) continue;
            res&=dfs(mat1,mat,x,y,m,n);
        }
        return res;
    }
}