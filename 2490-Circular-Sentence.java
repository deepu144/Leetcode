class Solution {
    public boolean isCircularSentence(String s) {
        int n=s.length();
        if(s.charAt(0)!=s.charAt(n-1)) return false;
        char pre=s.charAt(0);
        boolean space=false;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(space){
                if(pre!=ch) return false;
                space=false;
            }else{
                if(ch!=' ') pre=ch;
                if(ch==' ') space=true;
            }
        }
        return true;
    }
}