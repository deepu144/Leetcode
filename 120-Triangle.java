class Solution {
    public int minimumTotal(List<List<Integer>> tri) {
        int m=tri.size();
        int[][] dp=new int[m][m];
        for(int i=0;i<m;i++) dp[m-1][i]=tri.get(m-1).get(i);
        for(int i=m-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                if(i+1<m){
                    int a=dp[i+1][j]+tri.get(i).get(j);
                    int b=dp[i+1][j+1]+tri.get(i).get(j);
                    dp[i][j]=Math.min(a,b);
                }
            }
        }
        return dp[0][0];
    }
}