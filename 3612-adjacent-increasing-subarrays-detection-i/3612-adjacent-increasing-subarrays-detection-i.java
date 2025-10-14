class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        for(int i=0;i<=n-(2*k);i++){
            if(isIncreasing(nums,n,i,k) && isIncreasing(nums,n,i+k,k)) return true;
        }
        return false;
    }
    public boolean isIncreasing(List<Integer> nums,int n,int st,int k){
        int temp=st+k, prev = nums.get(st++);
        for(int i=st;i<temp;i++){
            if(prev >= nums.get(i)) return false;
            prev = nums.get(i);
        }
        return true;
    }
}