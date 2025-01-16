class Solution {
    public boolean isInterleave(String a, String b, String c) {
        int l=a.length(),m=b.length(),n=c.length();
        return match(a,b,c,l-1,m-1,n-1,new Boolean[l][m][n]);
    }
    public boolean match(String a,String b,String c,int i,int j,int k,Boolean[][][] dp){
        if(i<0 && j<0 && k<0) return true;
        if(i>=0 && j<0 && k>=0){
            while(i>=0 && k>=0){
                if(a.charAt(i)!=c.charAt(k)) return false;
                i--;
                k--;
            }
            return i==-1 && k==-1;
        }
        if(i<0 && j>=0 && k>=0){
            while(j>=0 && k>=0){
                if(b.charAt(j)!=c.charAt(k)) return false;
                j--;
                k--;
            }
            return j==-1 && k==-1;
        }
        if(i<0 || j<0 || k<0) return false;
        if(dp[i][j][k]!=null) return dp[i][j][k];
        char ac=a.charAt(i);
        char bc=b.charAt(j);
        char cc=c.charAt(k);
        if(ac==cc && cc==bc) return dp[i][j][k]=match(a,b,c,i-1,j,k-1,dp)||match(a,b,c,i,j-1,k-1,dp);
        else if(ac==cc) return dp[i][j][k]=match(a,b,c,i-1,j,k-1,dp);
        else if(cc==bc) return dp[i][j][k]=match(a,b,c,i,j-1,k-1,dp);
        return dp[i][j][k]=false;
    }
}