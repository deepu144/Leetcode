class Solution {
    double ans=1;
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        calculate(x, N);
        return ans;
    }
    public void calculate(double x,long n){
        if(n==0) return;
        if(n%2==0){
            x=x*x;
            n=n/2;
        }else{
            ans*=x;
            n=n-1;
        }
        calculate(x,n);
    }
}