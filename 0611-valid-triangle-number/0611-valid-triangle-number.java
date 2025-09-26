class Solution {
    public int triangleNumber(int[] nums) {
        int n = nums.length-1, cnt = 0;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                cnt += binarySearch(nums,j+1,n,nums[i]+nums[j]);
            }
        }
        return cnt;
    }
    public int binarySearch(int[] nums,int st,int end,int target){
        int n=st;
        while(st <= end){
            int mid = st + (end - st)/2;
            if(nums[mid] < target) st = mid+1;
            else end = mid-1;
        }
        return st-n;
    }
}