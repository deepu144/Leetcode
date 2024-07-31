class Solution {
    public int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length,min=nums[0]+k,max=nums[n-1]-k;
        int res=nums[n-1]-nums[0];
        for(int i=0;i<n-1;i++){
            int l=Math.min(min,nums[i+1]-k);
            int h=Math.max(max,nums[i]+k);
            res=Math.min(h-l,res);
        }
        return res;
    }
}