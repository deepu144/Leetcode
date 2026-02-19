class Solution {
    public boolean hasAlternatingBits(int n) {
        String s = Integer.toString(n, 2);
        n = s.length();
        for(int i = 1; i < n; i++){
            if(s.charAt(i-1) == s.charAt(i)) return false;
        }
        return true;
    }
}