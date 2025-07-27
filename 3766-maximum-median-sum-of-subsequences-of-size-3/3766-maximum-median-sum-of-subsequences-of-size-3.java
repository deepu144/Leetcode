class Solution {
    public long maximumMedianSum(int[] nums) {
        int n=nums.length,k=n/3;
        Arrays.sort(nums);
        long ans=0L;
        for(int i=n-2;i>=0 && k!=0;i-=2){
            k--;
            ans+=nums[i];
        }
        return ans;
    }
}