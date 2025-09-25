class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        return helper(triangle,0,0,n,new Integer[n][n]);
    }
    public int helper(List<List<Integer>> triangle,int i,int j,int n,Integer[][] dp){
        if(i==n) return 0;
        if(dp[i][j] != null) return dp[i][j];
        int max1 = helper(triangle,i+1,j,n,dp);
        int max2 = helper(triangle,i+1,j+1,n,dp);
        return dp[i][j] = Math.min(max1,max2) + triangle.get(i).get(j);
    }
}