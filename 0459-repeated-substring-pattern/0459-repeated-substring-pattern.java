class Solution {
    public boolean repeatedSubstringPattern(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s+s);
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length()-1);
        return sb.toString().contains(s);
    }
}