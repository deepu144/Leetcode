class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int n = nums.length, prev = -1, i=0;
        while(i<n && nums[i]==0) i++;
        prev = i++;
        while(i<n){
            if(nums[i] == 1){
                if(i-prev-1 < k) return false;
                prev = i;
            }
            i++;
        }
        return true;
    }
}