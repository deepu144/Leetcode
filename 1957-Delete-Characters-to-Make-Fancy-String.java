class Solution {
    public String makeFancyString(String s) {
        StringBuffer sb = new StringBuffer();
        int same=1;
        char pre=s.charAt(0);
        sb.append(pre);
        for(int i=1;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch==pre){
                if(same==2) continue;
                if(same<2){
                    sb.append(ch);
                    same++;
                }
            }else{
                sb.append(ch);
                pre=ch;
                same=1;
            }
        }
        return sb.toString();
    }
}