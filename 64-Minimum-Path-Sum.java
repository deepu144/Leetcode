class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0) dp[i][j]=grid[i][j];
                else{
                    int up=(int)(1e9),left=(int)(1e9);
                    if(i>0) up=dp[i-1][j]+grid[i][j];
                    if(j>0) left=dp[i][j-1]+grid[i][j];
                    dp[i][j]=Math.min(up,left);
                }
            }
        }
        return dp[m-1][n-1];
    }
}