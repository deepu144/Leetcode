class Solution {
    public int maximumDifference(int[] nums) {
        int min=nums[0],diff=-1,n=nums.length;
        for(int i=1;i<n;i++){
            if(min!=nums[i]) diff = Math.max(diff,nums[i]-min); 
            min = Math.min(min,nums[i]);
        }
        return diff;
    }
}