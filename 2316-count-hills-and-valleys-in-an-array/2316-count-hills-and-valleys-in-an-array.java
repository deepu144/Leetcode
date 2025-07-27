class Solution {
    public int countHillValley(int[] nums) {
        int n=nums.length,i=1,cnt=0;
        while(i<n-1){
            int val=nums[i],j=i+1;
            while(j<n-1 && nums[j]==val) j++;
            if((val>nums[i-1] && val>nums[j]) || (val<nums[i-1] && val<nums[j])) cnt++;
            i=j;
        }
        return cnt;
    }
}