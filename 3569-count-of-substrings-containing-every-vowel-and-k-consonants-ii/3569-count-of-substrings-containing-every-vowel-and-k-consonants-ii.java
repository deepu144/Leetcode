class Solution {
    public long countOfSubstrings(String word, int k) {
        int n=word.length();
        return helper(word,n,k)-helper(word,n,k+1);
    }
    public boolean isVowel(char ch){
        return ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u';
    }
    public long helper(String s,int n,int k){
        long count=0;
        int reqVow=5,currCon=0,left=0,right=0;
        int[] hash=new int[26];
        boolean f=true;
        while(right<n && left<n){
            char ch=' ';
            if(f){
                ch=s.charAt(right);
                if(isVowel(ch)){
                    if(hash[ch-'a']==0) reqVow--;
                }else currCon++;
                hash[ch-'a']++;
            }
            if(currCon>=k && reqVow==0){
                count+=(n-right);
                ch=s.charAt(left);
                hash[ch-'a']--;
                if(isVowel(ch)){
                    if(hash[ch-'a']==0) reqVow++;
                }else{
                    currCon--;
                }
                left++;
                f=false;
            }
            else{
                right++;
                f=true;
            }
        }
        return count;
    }
}