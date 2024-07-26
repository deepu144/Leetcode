class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        if(nums[0]>target) return 0;
        if(nums[n-1]<target) return n;
        return binarySearch(0,n-1,nums,target);
    }
    public int binarySearch(int start,int end,int[] arr,int target){
        if(start<=end){
            int mid = start+(end-start)/2;
            if(arr[mid]<target) return binarySearch(mid+1,end,arr,target);
            else if(arr[mid]>target) return binarySearch(start,mid-1,arr,target);
            else return mid;
        }
        return start;
    }
}