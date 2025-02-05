class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int n=s1.length(),differ=0;
        if(!isSameFrequency(s1,s2,n)) return false;
        for(int i=0;i<n;i++){
            if(s1.charAt(i)!=s2.charAt(i)) differ++;
            if(differ>2) return false;
        }
        return true;
    }
    public boolean isSameFrequency(String s,String t,int n){
        int[] hash=new int[26];
        for(int i=0;i<n;i++) hash[s.charAt(i)-'a']++;
        for(int i=0;i<n;i++) hash[t.charAt(i)-'a']--;
        for(int i=0;i<26;i++) if(hash[i]!=0) return false;
        return true;
    }
}