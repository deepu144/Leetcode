class Solution {
    public String addSpaces(String s, int[] spaces) {
        int i=0,j=0,l=s.length();
        StringBuilder sb=new StringBuilder();
        while(i<l){
            if(j<spaces.length && spaces[j]==i){
                sb.append(' ');
                j++;
            }else{
                sb.append(s.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }
}