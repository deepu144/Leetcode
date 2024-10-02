class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m=triangle.size(),n=triangle.get(m-1).size();
        if(m==1) return triangle.get(0).get(0);
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++) Arrays.fill(dp[i],-1);
        return generate(triangle,m,0,0,dp);
    }
    public int generate(List<List<Integer>> tri,int m,int r,int c,int[][] dp){
        if(c>=tri.get(r).size()) return (int)(1e9);
        if(r==m-1) return tri.get(r).get(c);
        if(dp[r][c]!=-1) return dp[r][c];
        int a=generate(tri,m,r+1,c,dp)+tri.get(r).get(c);
        int b=generate(tri,m,r+1,c+1,dp)+tri.get(r).get(c);
        return dp[r][c]=Math.min(a,b);
    }
}