class Solution {
    final int MOD=(int)(1e9+7);
    public int countPathsWithXorValue(int[][] grid, int k) {
        int m=grid.length,n=grid[0].length;
        Integer[][][] dp=new Integer[m+1][n+1][101];
        return (path(m-1,n-1,grid,0,k,dp)%MOD);
    }
    public int path(int i,int j,int[][] grid,int xor,int k,Integer[][][] dp){
        if(i<0||j<0) return 0;
        if(i==0 && j==0){
            xor^=grid[0][0];
            if(xor==k) return 1;
            return 0;
        }
        if(dp[i][j][xor]!=null) return dp[i][j][xor];
        int left=path(i-1,j,grid,xor^grid[i][j],k,dp);
        int right=path(i,j-1,grid,xor^grid[i][j],k,dp);
        return dp[i][j][xor]=(left+right)%MOD;
    }
}