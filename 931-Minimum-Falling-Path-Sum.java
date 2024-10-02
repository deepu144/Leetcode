class Solution {
    public int minFallingPathSum(int[][] mat) {
        int n=mat.length;
        int min=Integer.MAX_VALUE;
        Integer[][] dp =new Integer[n][n];
        for(int i=0;i<n;i++) min=Math.min(min,generate(mat,n,0,i,dp));
        return min;
    }
    public int generate(int[][] mat,int n,int r,int c,Integer[][] dp){
        if(c<0||c>=n) return (int)(1e6);
        if(dp[r][c]!=null) return dp[r][c];
        if(r==n-1) return mat[r][c];
        return dp[r][c]=mat[r][c]+Math.min(generate(mat,n,r+1,c,dp),Math.min(generate(mat,n,r+1,c-1,dp),generate(mat,n,r+1,c+1,dp)));
    }
}