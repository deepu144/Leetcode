class Solution {
    public boolean checkDivisibility(int n) {
        int sum=0,prod=1,t=n;
        while(t>0){
            int digit=t%10;
            sum+=digit;
            prod*=digit;
            t/=10;
        }
        return n%(sum+prod)==0;
    }
}