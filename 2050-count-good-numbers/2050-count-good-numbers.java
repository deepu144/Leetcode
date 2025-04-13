class Solution {
    public int countGoodNumbers(long n) {
        long odd = n/2;
        long even = n/2+n%2;
        int mod = (int)1e9+7;
        return (int)((power(5L,even,mod)*power(4L,odd,mod))%mod);
    }
    public long power(long a,long b , int mod){
        if(b==0) return 1;
        long ans=power(a,b/2,mod);
        ans*=ans;
        ans%=mod;
        if(!(b%2==0)) ans*=a;
        ans%=mod;
        return ans;
    }
}