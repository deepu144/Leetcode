class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int n=nums.length,i=0;
        long ans=0L;
        while(i<n){
            long cnt=0L;
            while(i<n && nums[i]==0){
                cnt++;
                i++;
            }
            ans+=(cnt*(cnt+1L))/2;
            i++;
        }
        return ans;
    }
}