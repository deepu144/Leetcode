class Solution {
    public int removeDuplicates(int[] nums) {
        int n=nums.length,a=1;
        for(int i=1;i<n;i++){
            if(nums[i-1]!=nums[i]){
                nums[a]=nums[i];
                a++;
            }
        }
        return a;
    }
}