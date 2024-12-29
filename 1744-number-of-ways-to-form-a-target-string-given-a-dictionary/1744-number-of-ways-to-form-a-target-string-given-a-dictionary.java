class Solution {
    final int MOD=(int)(1e9+7);
    public int numWays(String[] words, String target) {
        int n=target.length(),wordLen=words[0].length();
        int[][] fre=new int[wordLen][26];
        for(int i=0;i<wordLen;i++){
            for(int k=0;k<words.length;k++){
                char ch=words[k].charAt(i);
                fre[i][ch-'a']++;
            }
        }
        return helper(fre,target,n,wordLen,0,0,new Integer[wordLen+1][n+1]);
    }
    public int helper(int[][] fre,String target,int n,int wordLen,int i,int j,Integer[][] dp){
        if(j==n) return 1;
        if(i==wordLen) return 0;
        if(dp[i][j]!=null) return dp[i][j];
        char ch=target.charAt(j);
        long count=0;
        if(fre[i][ch-'a']>0){
            count=(count+((long)fre[i][ch-'a']*helper(fre,target,n,wordLen,i+1,j+1,dp)))%MOD;
        }
        count=(count+helper(fre,target,n,wordLen,i+1,j,dp))%MOD;
        return dp[i][j]=(int)count;
    }
}