class Solution {
    public String makeFancyString(String s) {
        int n=s.length();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            int m=sb.length();
            if(m<=1) sb.append(ch);
            else if(m-1>=0 && (ch!=sb.charAt(m-1) || (m-2>=0 && ch!=sb.charAt(m-2)))) sb.append(ch);
        }
        return sb.toString();
    }
}
