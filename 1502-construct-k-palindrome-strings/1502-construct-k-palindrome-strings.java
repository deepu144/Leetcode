class Solution {
    public boolean canConstruct(String s, int k) {
        int n=s.length(),odd=0;
        if(n<k) return false;
        int[] hash=new int[26];
        for(int i=0;i<n;i++) hash[s.charAt(i)-'a']++;
        for(int i=0;i<26;i++) if((hash[i]&1)==1) odd++;
        return odd<=k;
    }
}