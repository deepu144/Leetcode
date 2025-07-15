class Solution {
    public boolean isValid(String word) {
        boolean containsVowel=false,containsConsonent=false;
        int n=word.length();
        if(n<3) return false;
        for(int i=0;i<n;i++){
            char ch=word.charAt(i);
            if(!Character.isLetterOrDigit(ch)) return false;
            if(isVowel(ch)) containsVowel=true;
            else if(!Character.isDigit(ch)) containsConsonent=true;
        }
        return containsConsonent && containsVowel;
    }
    public boolean isVowel(char ch){
        ch = Character.toLowerCase(ch);
        return ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u';
    }
}