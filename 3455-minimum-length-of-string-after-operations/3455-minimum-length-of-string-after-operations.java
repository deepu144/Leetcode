class Solution {
    public int minimumLength(String s) {
        int n=s.length(),res=n;
        int[] hash=new int[26];
        for(int i=0;i<n;i++) hash[s.charAt(i)-'a']++;
        for(int i=0;i<26;i++){
            if(hash[i]==0) continue;
            if((hash[i]&1)==1) res-=(hash[i]-1);
            else res-=(hash[i]-2);
        }
        return res;
    }
}