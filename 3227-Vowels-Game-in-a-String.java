class Solution {
    public boolean doesAliceWin(String s) {
        char[] ch = s.toCharArray();
        int vowel=0,n=s.length();
        for(int i=0;i<n;i++){
            if(ch[i]=='a'||ch[i]=='e'||ch[i]=='i'||ch[i]=='o'||ch[i]=='u'){
                vowel++;
            }
        }
        if(vowel<1) return false;
        return true;
    }
}