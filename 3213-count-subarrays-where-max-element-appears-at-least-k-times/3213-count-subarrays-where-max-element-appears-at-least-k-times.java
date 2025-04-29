class Solution {
    public long countSubarrays(int[] nums, int k) {
        long ans=0L;
        int n=nums.length,right=0,left=0,cnt=0,max=0;
        for(int val : nums) max=Math.max(max,val);
        while(right<n){
            if(nums[right]==max) cnt++;
            while(cnt==k){
                ans+=(n-right);
                if(nums[left]==max) cnt--;
                left++;
            }
            right++;
        }
        return ans;
    }
}