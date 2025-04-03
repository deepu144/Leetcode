class Solution {
    public long maximumTripletValue(int[] nums) {
        int n=nums.length,maxDiff=0,max=0;
        long res=0;
        for(int val : nums){
            res=Math.max(res,(long)maxDiff*val);
            maxDiff=Math.max(maxDiff,max-val);
            max=Math.max(max,val);
        }
        return res;
    }
}