class Solution {
    public int minDistance(String s, String t) {
        int m=s.length(),n=t.length();
        return subsequence(s,t,m-1,n-1,new Integer[m][n]);
    }
    public int subsequence(String s,String t,int i,int j,Integer[][] dp){
        if(i<0) return j+1;
        if(j<0) return i+1;
        if(dp[i][j]!=null) return dp[i][j];
        if(s.charAt(i)==t.charAt(j)) return subsequence(s,t,i-1,j-1,dp);
        int delete = 1 + subsequence(s,t,i-1,j,dp);
        int insert = 1 + subsequence(s,t,i,j-1,dp);
        int replace = 1 + subsequence(s,t,i-1,j-1,dp);
        return dp[i][j]=Math.min(delete,Math.min(insert,replace));
    }
}