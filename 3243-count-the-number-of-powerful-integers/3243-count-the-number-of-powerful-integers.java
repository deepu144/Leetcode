class Solution {
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        String b=String.valueOf(start-1);
        String f=String.valueOf(finish);
        int bLength=b.length(),fLength=f.length(),sLength=s.length();
        return Math.max(0L,helper(f,fLength,s,sLength,fLength,1,limit,new Long[fLength+1][2])-
                helper(b,bLength,s,sLength,bLength,1,limit,new Long[bLength+1][2]));
    }
    public long helper(String num,int numLength,String s,int sLength,int n,int tight,int limit,Long[][] dp){
        if(num.length()<s.length()) return 0L;
        if(dp[n][tight]!=null) return dp[n][tight];
        int upperBound= tight==1 ? num.charAt(numLength-n)-'0' : 9;
        long ans=0L;
        if(n==1){
            int a = s.charAt(sLength-n)-'0';
            if(a>upperBound) return 0L;
            return 1L;
        }
        if(n<=sLength){
            if(tight==1){
                int a = s.charAt(sLength-n)-'0';
                if(a>upperBound) return 0L;
                else if(a==upperBound) return helper(num,numLength,s,sLength,n-1,1,limit,dp);
            }
            return 1L;
        }else{
            for(int i=0; i<=Math.min(upperBound,limit) ;i++){
                boolean canTight = i==upperBound && tight==1;
                ans += helper(num,numLength,s,sLength,n-1,canTight ? 1 : 0,limit,dp);
            }
        }
        return dp[n][tight]=ans;
    }
}