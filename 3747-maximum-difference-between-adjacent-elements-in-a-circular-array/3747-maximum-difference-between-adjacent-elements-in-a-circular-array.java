class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int n=nums.length,max=(int)(-1e9);
        max=Math.abs(nums[0]-nums[n-1]);
        for(int i=0;i<n;i++){
            max=Math.max(max,Math.abs(nums[(i+1)%n]-nums[i]));
        }
        return max;
    }
}