class Solution {
    public String generateTag(String caption) {
        int n=caption.length();
        StringBuilder sb=new StringBuilder("#");
        boolean isSpace=false;
        int cnt=1,j=0;
        while(j<n && caption.charAt(j)==32) j++;
        for(int i=j;i<n;i++){
            char ch=caption.charAt(i);
            if(ch==32){
                isSpace=true;
                continue;
            }
            if(Character.isAlphabetic(ch)){
                if(isSpace) ch=Character.toUpperCase(ch);
                else ch=Character.toLowerCase(ch);
                sb.append(ch);
                isSpace=false;
                cnt++;
            }
            if(cnt==100) break;
        }
        return sb.toString();
    }
}