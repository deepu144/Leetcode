class Solution {
    int sum=0;
    public int subsetXORSum(int[] nums) {
        subset(nums,nums.length-1,0);
        return sum;
    }
    public void subset(int[] nums,int i,int xor){
        if(i<0){
            sum+=xor;
            return;
        }
        subset(nums,i-1,xor^nums[i]);
        subset(nums,i-1,xor);
    }
}