class Solution {
    public int minCut(String s) {
        int n=s.length();
        return cut(s,0,n,new Integer[n+1]);
    }
    public int cut(String s,int ind,int n,Integer[] dp){
        if(ind>=n-1) return 0;
        if(dp[ind]!=null) return dp[ind];
        int count=0,min=(int)(1e9);
        for(int i=ind;i<n;i++){
            if(isPalindrome(s,ind,i)){
                if(i==n-1) count = 0 + cut(s,i+1,n,dp);
                else count = 1 + cut(s,i+1,n,dp);
                min=Math.min(min,count);
            }
        }
        return dp[ind]=min;
    }
    public boolean isPalindrome(String str,int a,int b){
        while(a<b){
            if(str.charAt(a++)!=str.charAt(b--)) return false;
        }
        return true;
    }
}