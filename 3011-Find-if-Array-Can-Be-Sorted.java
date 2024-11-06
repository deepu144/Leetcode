class Solution {
    public boolean canSortArray(int[] nums) {
        int n=nums.length;
        int[] arr=new int[257];
        for(int i=0;i<n;i++) arr[nums[i]]=Integer.bitCount(nums[i]);
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(nums[j]>nums[j+1] && arr[nums[j]]==arr[nums[j+1]]){
                    int t=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=t;
                }
            }
        }
        for(int i=1;i<n;i++) if(nums[i]<nums[i-1]) return false;
        return true;
    }
}