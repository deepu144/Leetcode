class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb=new StringBuilder(s);
        int index=s.indexOf(part),n=part.length();
        while((index=sb.indexOf(part))!=-1) sb.delete(index,index+n);
        return sb.toString();
    }
}