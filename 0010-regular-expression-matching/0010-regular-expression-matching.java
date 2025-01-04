class Solution {
    public boolean isMatch(String s, String p) {
        final int m=p.length(),n=s.length();
        return isMatch(s.toCharArray(),p.toCharArray(),n-1,m-1,new Boolean[n][m]);
    }
    public boolean isMatch(char[] s,char[] p,int i,int j,Boolean[][] dp){
        if(i<0 && j<0) return true;
        if(j<0 && i>=0) return false;
        if(i<0 && j>=0){
            while(j>=0){
                if(p[j]=='*') j-=2;
                else return false;
            }
            return true;
        }
        if(dp[i][j]!=null) return dp[i][j];
        if(p[j]==s[i]){
            return dp[i][j]=isMatch(s,p,i-1,j-1,dp);
        }else if(p[j]=='.'){
            p[j]=s[i];
            boolean res=isMatch(s,p,i-1,j-1,dp);
            p[j]='.';
            return dp[i][j]=res;
        }else if(p[j]=='*'){
            if(isMatch(s,p,i,j-2,dp)) return dp[i][j]=true;
            if(p[j-1]=='.') return dp[i][j]=isMatch(s,p,i-1,j-2,dp)||isMatch(s,p,i-1,j,dp);
            else if(p[j-1]==s[i]) return dp[i][j]=isMatch(s,p,i-1,j,dp)||isMatch(s,p,i,j-1,dp);
        }
        return dp[i][j]=false;
    }
}