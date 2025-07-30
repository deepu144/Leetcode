class Solution {
    public int longestSubarray(int[] nums) {
        int n=nums.length,max=0,next=nums[n-1],cnt=1,ans=1;
        int[] arr=new int[n];
        for(int val : nums) max=Math.max(max,val);
        arr[n-1]=cnt;
        for(int i=n-2;i>=0;i--){
            if(next==nums[i]) cnt++;
            else{
                cnt=1;
                next=nums[i];
            }
            arr[i]=cnt;
        }
        for(int i=0;i<n;i++) if(nums[i]==max) ans=Math.max(ans,arr[i]);
        return ans;
    }
}