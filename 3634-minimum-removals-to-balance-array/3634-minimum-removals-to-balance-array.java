class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length, min = n;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            int floor = getFloorOrTarget(nums, n, 1L * nums[i] * k);
            min = Math.min(min, n - (floor - i + 1));
        }
        return min;
    }
    public int getFloorOrTarget(int[] nums, int n, long target) {
        int start = 0, end = n-1;
        if(nums[end] <= target) return end;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] > target) end = mid-1;
            else start = mid+1;
        }
        return --start;
    }
}