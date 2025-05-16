class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n=words.length,max=0,lastIndex=0;
        int[] dp=new int[n];
        int[] hash=new int[n];
        Arrays.fill(dp,1);
        for(int i=1;i<n;i++){
            hash[i]=i;
            for(int j=0;j<i;j++){
                if(groups[i]!=groups[j] && isHammingDistanceOne(words[i],words[j])){
                    if(dp[i] < dp[j]+1){
                        dp[i]=dp[j]+1;
                        hash[i]=j;
                    }
                }
            }
            if(dp[i] > max){
                max=dp[i];
                lastIndex=i;
            }
        }
        List<String> ans=new ArrayList<>();
        while(hash[lastIndex]!=lastIndex){
            ans.add(words[lastIndex]);
            lastIndex=hash[lastIndex];
        }
        ans.add(words[lastIndex]);
        Collections.reverse(ans);
        return ans;
    }
    public boolean isHammingDistanceOne(String s,String p){
        int n=s.length();
        if(n!=p.length()) return false;
        boolean differ=false;
        for(int i=0;i<n;i++){
            if(s.charAt(i)!=p.charAt(i)){
                if(differ) return false;
                differ=true;
            }
        }
        return differ;
    }
}