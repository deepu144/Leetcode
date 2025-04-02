class Solution {
    public long maximumTripletValue(int[] nums) {
        long ans=0;
        int n=nums.length,maxDiff=0,max=0;
        for(int i=0;i<n;i++){
            ans=Math.max(ans,(long)maxDiff*nums[i]);
            maxDiff=Math.max(maxDiff,max-nums[i]);
            max=Math.max(max,nums[i]);
        }
        return ans;
    }
}