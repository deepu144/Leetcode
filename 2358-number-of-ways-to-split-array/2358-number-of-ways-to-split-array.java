class Solution {
    public int waysToSplitArray(int[] nums) {
        int n=nums.length,count=0;
        long sum=0;
        long[] arr=new long[n+1];
        for(int i=0;i<n;i++){
            sum+=nums[i];
            arr[i+1]=sum;
        }
        for(int i=0;i<n-1;i++) if((arr[i+1])>=(arr[n]-arr[i+1])) count++;
        return count;
    }
}