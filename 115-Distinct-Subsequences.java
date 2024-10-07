class Solution {
    public int numDistinct(String s1, String s2) {
        int m=s1.length(),n=s2.length();
        return subsequence(s1,s2,m-1,n-1,new Integer[m+1][n+1]); 
    }
    public int subsequence(String s,String t,int i,int j,Integer[][] dp){
        if(j==-1) return 1;
        if(i==-1) return 0;
        if(dp[i][j]!=null) return dp[i][j];
        if(s.charAt(i)==t.charAt(j)) dp[i][j] = subsequence(s,t,i-1,j-1,dp) + subsequence(s,t,i-1,j,dp);
        else dp[i][j] = subsequence(s,t,i-1,j,dp);
        return dp[i][j];
    }
}