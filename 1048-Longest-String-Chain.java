class Solution {
    public int longestStrChain(String[] words) {
        int n=words.length;
        if(n==1) return n;
        Arrays.sort(words,(a,b)->a.length()-b.length());
        int[] dp=new int[n];
        int maxi=0;
        Arrays.fill(dp,1);
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(check(words[i],words[j]) && dp[j]+1>dp[i]){
                    dp[i]=dp[j]+1;
                }
            }
            maxi=Math.max(maxi,dp[i]);
        }
        return maxi;
    }
    public boolean check(String s,String t){
        int diff=0,m=s.length(),n=t.length();
        if(m-n!=1) return false;
        int i=0,j=0;
        while(i<m && j<n){
            if(t.charAt(j)!=s.charAt(i)){
                diff++;
                if(diff==2) return false;
            }else j++;
            i++;
        }
        while(i<m){
            diff++;
            if(diff>=2) return false;
            i++;
        }
        return diff==1;
    }
}