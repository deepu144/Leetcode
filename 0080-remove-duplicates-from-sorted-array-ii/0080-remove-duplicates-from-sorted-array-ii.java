class Solution {
    public int removeDuplicates(int[] nums) {
        int n=nums.length,l=1,r=1,prev=nums[0],dup=0,cnt=1;
        while(r<n){
            if(nums[r]==prev){
                if(cnt<2){
                    cnt++;
                    nums[l++]=nums[r];
                }
                else if(cnt>=2) dup++;
            }else{
                nums[l++]=nums[r];
                prev=nums[r];
                cnt=1;
            }
            r++;
        }
        return n-dup;
    }
}