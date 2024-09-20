class Solution {
    public String shortestPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        int index=-1;
        for(int i=0;i<sb.length();i++){
            if(s.startsWith(sb.substring(i))){
                index=i;
                break;
            }
        }
        if(index==-1) return sb.toString()+s;
        return sb.substring(0,index)+s;
    }
}