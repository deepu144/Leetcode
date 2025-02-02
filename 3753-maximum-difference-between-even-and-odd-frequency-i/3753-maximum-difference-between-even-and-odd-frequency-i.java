class Solution {
    public int maxDifference(String s) {
        int[] hash=new int[26];
        int n=s.length(),max=(int)(-1e8);
        for(int i=0;i<n;i++) hash[s.charAt(i)-'a']++;
        for(int i=0;i<26;i++){
            for(int j=i+1;j<26;j++){
                if(hash[i]%2!=hash[j]%2 && hash[j]!=0 && hash[i]!=0){
                    if(hash[i]%2==1) max=Math.max(max,hash[i]-hash[j]);
                    else max=Math.max(max,hash[j]-hash[i]);
                }
            }
        }
        return max;
    }
}