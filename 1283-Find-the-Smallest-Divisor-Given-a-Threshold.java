class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int end=-1,start=1;
        for(int n:nums) end=Math.max(end,n);
        while(start<=end){
            int mid=start+(end-start)/2;
            int t=sum(nums,mid);
            if(t>threshold){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return start;
    }
    public int sum(int[] arr,int div){
        int ans=0;
        for(int n:arr){
            ans+=(int)Math.ceil((double)n/div);
        }
        return ans;
    }
}