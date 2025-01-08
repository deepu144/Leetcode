class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n=grid[0].length,res=(int)(1e8);
        return minPath(grid,n,0,-1,new Integer[n][n+1]);
    }
    public int minPath(int[][] grid,int n,int row,int pre,Integer[][] dp){
        if(row==n) return 0;
        if(dp[row][pre+1]!=null) return dp[row][pre+1];
        int min=(int)(1e8);
        for(int i=0;i<n;i++){
            if(pre==i) continue;
            min=Math.min(min,grid[row][i]+minPath(grid,n,row+1,i,dp));
        }
        return dp[row][pre+1]=min;
    }
}