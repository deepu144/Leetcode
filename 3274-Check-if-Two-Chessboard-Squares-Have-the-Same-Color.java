class Solution {
    public boolean checkTwoChessboards(String c1, String c2) {
        boolean a = (c1.charAt(0)-96)%2 != (c1.charAt(1)-'0')%2;
        boolean b = (c2.charAt(0)-96)%2 != (c2.charAt(1)-'0')%2;
        if(!(a^b)) return true;
        return false;
    }
}