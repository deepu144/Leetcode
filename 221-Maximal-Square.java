class Solution {
    public int maximalSquare(char[][] mat) {
        int m=mat.length,n=mat[0].length,ans=0;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            dp[i][0]=mat[i][0]-'0';
            ans=Math.max(ans,dp[i][0]*dp[i][0]);
        }
        for(int i=0;i<n;i++){
            dp[0][i]=mat[0][i]-'0';
            ans=Math.max(ans,dp[0][i]*dp[0][i]);
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(mat[i][j]=='1'){
                    dp[i][j]=Math.min(dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j-1]))+1;
                    ans=Math.max(ans,dp[i][j]*dp[i][j]);
                }
            }
        }
        return ans;
    }
}