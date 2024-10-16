class Solution {
    public int countSquares(int[][] mat) {
        int m=mat.length,n=mat[0].length,count=0;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            dp[i][0]=mat[i][0];
            count+=dp[i][0];
        }
        for(int i=1;i<n;i++){
            dp[0][i]=mat[0][i];
            count+=dp[0][i];
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(mat[i][j]!=0){
                    int min=Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]));
                    dp[i][j]=min+1;
                }
                count+=dp[i][j];
            }
        }
        return count;
    }
}