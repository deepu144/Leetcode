class Solution {
    public int countOfSubstrings(String word, int k) {
        int n=word.length(),ans=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<=n;j++){
                if(check(word.substring(i,j),k)) ans++;
            }
        }
        return ans;
    }
    public boolean check(String s,int k){
        int[] hash=new int[26];
        int con=0;
        for(char c : s.toCharArray()){
            if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u') hash[c-'a']++;
            else con++;
            if(con>k) return false;
        }
        if (hash['a'-'a']>0 && hash['e'-'a']>0 && hash['i'-'a']>0 && hash['o'-'a']>0 && hash['u'-'a']>0) {
            if(con==k) return true;
        }
        return false;
    }
}