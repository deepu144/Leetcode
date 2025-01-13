class Solution {
    public int hIndex(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length,hIndex=0;
        for(int i=n-1;i>=0;i--){
            int t=n-i;
            if(nums[i]>=t) hIndex=t;
        }
        return hIndex;
    }
}