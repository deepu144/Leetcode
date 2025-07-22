class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n=nums.length,l=0,max=0,curr=0;
        boolean[] hash=new boolean[10001];
        for(int r=0;r<n;r++){
            int val = nums[r];
            while(hash[val]){
                curr-=nums[l];
                hash[nums[l++]]=false;
            }
            curr+=val;
            hash[val]=true;
            max=Math.max(max,curr);
        }
        return max;
    }
}