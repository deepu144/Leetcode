class Solution {
    public int countSubarrays(int[] nums) {
        int count=0,n=nums.length;
        for(int i=0;i<n;i++){
            if(i+2<n){
                if((nums[i]+nums[i+2])*2==nums[i+1]) count++;
            }
        }
        return count;
    }
}