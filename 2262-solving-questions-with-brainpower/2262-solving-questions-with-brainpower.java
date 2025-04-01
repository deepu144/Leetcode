class Solution {
    public long mostPoints(int[][] questions) {
        int n=questions.length;
        long[] dp=new long[n+1];
        for(int i=n-1;i>=0;i--){
            long take=questions[i][0];
            int j=i+1+questions[i][1];
            if(j<=n) take+=dp[j];
            long notTake=dp[i+1];
            dp[i]=Math.max(take,notTake);
        }
        return dp[0];
    }
}