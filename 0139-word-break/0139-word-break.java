class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<String,Integer> map=new HashMap<>();
        for(String t : wordDict) map.put(t,1);
        int n=s.length();
        return partition(s,n,0,map,new Boolean[n+1]);
    }
    public boolean partition(String s,int n,int ind,HashMap<String,Integer> map,Boolean[] dp){
        if(ind==n) return true;
        if(dp[ind]!=null) return dp[ind];
        for(int i=ind;i<n;i++){
            if(map.containsKey(s.substring(ind,i+1))){
                if(partition(s,n,i+1,map,dp)) return dp[ind]=true;
            }
        }
        return dp[ind]=false;
    }
}