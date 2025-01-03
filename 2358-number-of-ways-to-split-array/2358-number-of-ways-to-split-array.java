class Solution {
    public int waysToSplitArray(int[] nums) {
        int n=nums.length,count=0;
        long sum=0,curr=0;
        for(int i=0;i<n;i++) sum+=nums[i];
        for(int i=0;i<n-1;i++){
            curr+=nums[i];
            if(curr>=sum-curr) count++;
        }
        return count;
    }
}