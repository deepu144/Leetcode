class Solution {
    public int smallestNumber(int n) {
        int p = (int) Math.ceil(Math.log(n + 1) / Math.log(2));
        return (1 << p) - 1;
    }
}