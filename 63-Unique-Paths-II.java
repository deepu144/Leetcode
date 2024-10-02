class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        if(grid[0][0]==1) return 0;
        int m=grid.length,n=grid[0].length;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++) Arrays.fill(dp[i],-1);
        return generate(grid,m,n,m-1,n-1,dp);
    }
    public int generate(int[][] grid,int m,int n,int r,int c,int[][] dp){
        if(r==0 && c==0) return 1;
        if(r<0||c<0||grid[r][c]==1) return 0;
        if(dp[r][c]!=-1) return dp[r][c];
        return dp[r][c]=generate(grid,m,n,r-1,c,dp)+generate(grid,m,n,r,c-1,dp);
    }
}