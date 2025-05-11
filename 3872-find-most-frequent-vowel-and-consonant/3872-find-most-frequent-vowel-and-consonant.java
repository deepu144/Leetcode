class Solution {
    public int maxFreqSum(String s) {
        int n=s.length();
        int[] vowel=new int[26];
        int[] consonent=new int[26];
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(isVowel(ch)) vowel[ch-'a']++;
            else consonent[ch-'a']++;
        }
        return max(vowel)+max(consonent);
    }
    public int max(int[] hash){
        int max=0;
        for(int a : hash) max=Math.max(a,max);
        return max;
    }
    public boolean isVowel(char ch){
        return ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u';
    }
}