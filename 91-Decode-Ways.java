class Solution {
    public int numDecodings(String s) {
        int n=s.length();
        int[] dp=new int[n+1];
        dp[n]=1;
        for(int ind=n;ind>=0;ind--){
            for(int i=ind;i<n;i++){
                if(isValid(s.substring(ind,i+1))){
                    dp[ind]+=dp[i+1];
                }
            }
        }
        return dp[0];
    }
    public boolean isValid(String s){
        if(s.isEmpty()||s.length()>=3) return false;
        if(s.charAt(0)=='0' && s.length()>=1) return false;
        int n=Integer.parseInt(s);
        if(n<0 || n>26) return false;
        return true;
    }
}