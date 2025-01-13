class Solution {
    public int removeElement(int[] nums, int val) {
        int n=nums.length,a=0,b=1;
        if(n==0) return n;
        int count=nums[a]==val?1:0;
        while(b<n){
            if(nums[b]==val) count++;
            if(nums[a]!=val){
                a++;
                b++;
            }else if(nums[a]==val && nums[b]!=val){
                int t=nums[a];
                nums[a++]=nums[b];
                nums[b++]=t;
            }else if(nums[a]==val && nums[b]==val) b++;
        }
        return n-count;
    }
}