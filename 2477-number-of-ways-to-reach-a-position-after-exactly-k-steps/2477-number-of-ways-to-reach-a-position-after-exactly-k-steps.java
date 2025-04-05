class Solution {
    final int MOD=(int)(1e9+7);
    public int numberOfWays(int startPos, int endPos, int k){
        if(startPos>endPos) return numberOfWays(endPos,startPos,k);
        int low=startPos-k,end=endPos+k,n=end-low+1,offset=0;
        if(low<0) offset=-1*low;
        Integer[][] dp=new Integer[n+offset+1][k];
        return helper(startPos,endPos,k-1,dp,offset,(low<0)?0:low);
    }
    public int helper(int st,int end,int k,Integer[][] dp,int offset,int t){
        if(k<0) return st==end?1:0;
        if(dp[st+offset-t][k]!=null) return dp[st+offset-t][k];
        int back=helper(st-1,end,k-1,dp,offset,t);
        int front=helper(st+1,end,k-1,dp,offset,t);
        return dp[st+offset-t][k]=(back+front)%MOD;
    }
}