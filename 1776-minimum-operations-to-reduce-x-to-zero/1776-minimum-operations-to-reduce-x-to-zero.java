class Solution {
    public int minOperations(int[] nums, int x) {
        int n=nums.length,left=0,right=0,tot=0,maxLength=-1;
        for(int i : nums) tot+=i;
        if(tot<x) return -1;
        if(tot==x) return n;
        int sum=0;
        while(right<n && left<n){
            sum+=nums[right];
            while(sum>tot-x) sum-=nums[left++];
            if(sum==tot-x){
                maxLength=Math.max(maxLength,right-left+1);
                sum-=nums[left++];
            }
            right++;
        }
        return maxLength==-1?-1:n-maxLength;
    }
}