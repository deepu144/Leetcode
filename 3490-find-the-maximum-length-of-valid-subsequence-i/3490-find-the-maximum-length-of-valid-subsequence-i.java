class Solution {
    public int maximumLength(int[] nums) {
        int n=nums.length;
        if(n==2) return n;
        return Math.max( helper(nums,n) , Math.max( helper(n,nums,true) , helper(n,nums,false) ) );
    }
    public int helper(int[] nums,int n){
        int cnt1=0,cnt2=0;
        for(int val : nums){
            if((val&1)==0) cnt1++;
            else cnt2++;
        }
        return Math.max(cnt1,cnt2);
    }
    public int helper(int n,int[] nums,boolean isNextEven){
        int cnt=0;
        for(int val : nums){
            boolean isEven=(val&1)==0;
            if(isNextEven && isEven){
                cnt++;
                isNextEven=false;
            }else if(!isNextEven && ! isEven){
                cnt++;
                isNextEven=true;
            }
        }
        return cnt;
    }
}