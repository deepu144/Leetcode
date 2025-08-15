class Solution {
    public boolean isPowerOfFour(int n) {
        if((n & ( n-1 )) != 0 || n == 0) return false;
        return (Math.ceil(Math.log(n)/Math.log(4)))==(Math.log(n)/Math.log(4));
    }
}