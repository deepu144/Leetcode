class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n=nums.length,j=0,pivotCount=0;
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]<pivot) res[j++]=nums[i];
            else if(nums[i]==pivot) pivotCount++;
        }
        for(int i=0;i<pivotCount;i++) res[j++]=pivot;
        for(int i=0;i<n;i++) if(nums[i]>pivot) res[j++]=nums[i];
        return res;
    }
}