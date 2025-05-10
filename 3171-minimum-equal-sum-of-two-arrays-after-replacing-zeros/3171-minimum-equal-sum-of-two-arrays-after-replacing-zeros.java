class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1=0L,sum2=0L;
        int n=nums1.length,m=nums2.length,zeroCnt1=0,zeroCnt2=0;
        for(int a : nums1){
            if(a==0) zeroCnt1++;
            sum1+=a;
        }
        for(int a : nums2){
            if(a==0) zeroCnt2++;
            sum2+=a;
        }
        sum1+=zeroCnt1;
        sum2+=zeroCnt2;
        if(sum1>=sum2){
            if(zeroCnt2>0 || sum1==sum2) return sum1;
            else return -1;
        }else{
            if(zeroCnt1>0) return sum2;
            else return -1;
        }
    }
}