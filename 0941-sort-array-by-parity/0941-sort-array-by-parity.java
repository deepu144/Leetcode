class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int j=(nums[0]&1)==1?0:1,n=nums.length;
        for(int i=1;i<n;i++){
            if((nums[i]&1)==0){
                swap(i,j,nums);
                j++;
            }
        }
        return nums;
    }
    public void swap(int i,int j,int[] nums){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
}