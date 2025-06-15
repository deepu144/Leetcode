class Solution {
    final static int MAX=100000;
    final static int MOD=(int)(1e9+7);
    public int specialTriplets(int[] nums) {
        int n=nums.length;
        long res=0L;
        long[] left=new long[MAX+1];
        long[] right=new long[MAX+1];
        for(int val : nums) right[val]++;
        for(int i=0;i<n;i++){
            int val = nums[i];
            right[val]--;
            int expect = 2*val;
            if(expect <= MAX){
                long lCount = left[expect];
                long rCount = right[expect];
                res = (res+lCount*rCount)%MOD;
            }
            left[val]++;
        }
        return (int)res;
    }
}