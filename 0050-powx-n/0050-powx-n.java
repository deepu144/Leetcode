class Solution {
    public double myPow(double x, int n) {
        long m = n;
        if(m < 0) return helper(1/x, -m);
        return helper(x, m);
    }

    public double helper(double x, long n) {
        if(n == 0) return 1.0;
        if((n&1) == 0) return helper(x*x, n/2);
        return x * helper(x, n-1);
    }
}