class Solution {
    public boolean isTrionic(int[] nums) {
        int n=nums.length,cnt=0,i=0,prev=0;
        if(n==3) return false;
        while(i+1<n){
            if(nums[i]<nums[i+1]) i++;
            else if(nums[i]==nums[i+1]) return false;
            else break;
        }
        if(i>=n-1 || prev==i) return false;
        prev=i;
        while(i+1<n){
            if(nums[i]>nums[i+1]) i++;
            else if(nums[i]==nums[i+1]) return false;
            else break;
        }
        if(i>=n-1 || prev==i) return false;
        prev=i;
        while(i+1<n){
            if(nums[i]<nums[i+1]) i++;
            else if(nums[i]==nums[i+1]) return false;
            else break;
        }
        if(i<n-1) return false;
        return true;
    }
}