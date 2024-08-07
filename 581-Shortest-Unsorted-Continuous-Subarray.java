class Solution {
    public int findUnsortedSubarray(int[] nums){
        int n=nums.length;
        int min=nums[n-1],max=nums[0],r=-1,l=0;
        for(int i=1;i<n;i++){
            if(nums[i]<max) r=i;
            else max=nums[i];
        }
        for(int i=n-2;i>=0;i--){
            if(nums[i]>min) l=i;
            else min=nums[i];
        }   
        return r-l+1;
    }
}