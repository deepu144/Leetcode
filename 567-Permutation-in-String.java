class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n=s2.length(),m=s1.length();
        if(m>n) return false;
        for(int i=0;i<n;i++){
            if(i+m<=n) if(check(s2.substring(i,i+m),s1,m)) return true;
        }
        return false;
    }
    public boolean check(String a,String b,int m){
        int[] hash=new int[26];
        for(char c : a.toCharArray()) hash[c-'a']++;
        for(char c : b.toCharArray()) hash[c-'a']--;
        for(int i=0;i<26;i++) if(hash[i]!=0) return false;
        return true;
    }
}