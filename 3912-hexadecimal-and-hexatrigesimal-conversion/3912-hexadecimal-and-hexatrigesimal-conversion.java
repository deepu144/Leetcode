class Solution {
    public String concatHex36(int n) {
        int square = n*n;
        return (Integer.toString(square,16)+Integer.toString(square*n,36)).toUpperCase();
    }
}