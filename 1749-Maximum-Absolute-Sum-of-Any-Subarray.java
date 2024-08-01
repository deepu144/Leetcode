class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int ans1=0,ans2=0,max1=nums[0],max2=nums[0];
        for(int n:nums){
            ans1+=n;
            max1=Math.max(max1,ans1);
            if(ans1<0) ans1=0;
        }
        for(int n:nums){
            ans2+=n;
            max2=Math.min(max2,ans2);
            if(ans2>0) ans2=0;
        }
        return Math.max(max1,Math.abs(max2));
    }
}