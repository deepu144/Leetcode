class Solution {
    public long countSubarrays(int[] nums, long k){
        long count=0,sum=0;
        int n=nums.length,left=0,right=0;
        while(right<n){
            sum+=nums[right];
            while(left<=right && sum*(right-left+1) >= k) sum-=nums[left++];
            count+=(right-left+1);
            right++;
        }
        return count;
    }
}