class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        boolean[] letters = new boolean[26];
        int n = brokenLetters.length(),j=0,cnt=0;
        for(int i=0;i<n;i++) letters[brokenLetters.charAt(i)-'a']=true;
        n=text.length();
        while(j<n){
            boolean flag=true;
            char ch='.';
            while(j<n && (ch=text.charAt(j))!=' '){
                if(letters[ch-'a']) flag=false;
                j++;
            }
            j++;
            if(flag) cnt++;
        }
        return cnt;
    }
}