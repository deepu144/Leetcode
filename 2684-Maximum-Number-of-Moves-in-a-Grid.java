class Solution {
    final int[][] dir={{0,-1},{-1,-1},{1,-1}}; 
    public int maxMoves(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int[][] dp=new int[m][n];
        for(int j=n-1;j>=1;j--){
            for(int i=0;i<m;i++){
                for(final int[] a : dir){
                    final int x=a[0]+i;
                    final int y=a[1]+j;
                    if(x<0||y<0||x>=m||y>=n||grid[i][j]<=grid[x][y]) continue;
                    dp[x][y]=Math.max(dp[x][y],dp[i][j]+1);
                }
            }
        }
        int max=0;
        for(int i=0;i<m;i++) max=Math.max(max,dp[i][0]);
        return max;
    }
}