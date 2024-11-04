class Solution {
    public String compressedString(String word) {
        StringBuilder sb=new StringBuilder();
        int count=0,i=0,n=word.length();
        while(i<n){
            char cur=word.charAt(i);
            if(i+1<n && cur==word.charAt(i+1)){
                count++;
                if(count==9){
                    sb.append(count);
                    sb.append(cur);
                    count=0;
                }
            }else if(i+1<n && cur!=word.charAt(i+1)){
                sb.append(++count);
                sb.append(cur);
                count=0;
            }else if(i+1==n){
                sb.append(++count);
                sb.append(cur);
            }
            i++;
        }
        return sb.toString();
    }
}