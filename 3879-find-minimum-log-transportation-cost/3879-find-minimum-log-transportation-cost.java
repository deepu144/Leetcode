class Solution {
    public long minCuttingCost(int n, int m, int k) {
        int val = (n>k) ? n : 0;
        long min=(long)(1e15);
        val = (m>k) ? m : val;
        if(val==0) return val;
        long i=1,j=val-1;
        while(min>=(long)(1e15)){
            if(i<=k && j<=k) min=i*j;
            i++;
            j--;
        }
        return min;
    }
}