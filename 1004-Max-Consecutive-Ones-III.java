class Solution {
    public int longestOnes(int[] nums, int k) {
        int max=-1,l=0,r=0,count=0,o=0;
        int n = nums.length;
        while(r<n){
            if(nums[r]==1 && o<=k){
                count++;
                r++;
                max=Math.max(max,r-l);
            }else if(o<k){
                count++;
                o++;
                r++;
                max=Math.max(max,r-l);
            }else if(o>=k){
                if(nums[l]==1){
                    count--;
                }else{
                    o--;
                }
                l++;
            }
        }
        return max;
    }
}