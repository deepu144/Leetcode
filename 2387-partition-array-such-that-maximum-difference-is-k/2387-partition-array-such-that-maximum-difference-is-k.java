class Solution {
    public int partitionArray(int[] nums, int k) {
        int n=nums.length,i=0,cnt=0;
        Arrays.sort(nums);
        while(i<n){
            int min=nums[i];
            while(i<n && nums[i]-min <= k) i++;
            cnt++;
        }
        return cnt;
    }
}