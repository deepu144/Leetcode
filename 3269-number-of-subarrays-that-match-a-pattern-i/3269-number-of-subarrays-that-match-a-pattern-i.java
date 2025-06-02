class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int n=nums.length,cnt=0,m=pattern.length;
        for(int i=0;i<=n-m-1;i++){
            if(isMatch(nums,n,i,pattern,m)) cnt++;
        }
        return cnt;
    }
    public boolean isMatch(int[] nums,int n,int i,int[] pattern,int m){
        int t=i;
        i++;
        int j=0;
        while(i<=t+m){
            if(pattern[j]==0){
                if(nums[i-1]!=nums[i]) return false;
            }else if(pattern[j]==1){
                if(nums[i-1] >= nums[i]) return false;
            }else{
                if(nums[i-1] <= nums[i]) return false;
            }
            i++;
            j++;
        }
        return true;
    }
}