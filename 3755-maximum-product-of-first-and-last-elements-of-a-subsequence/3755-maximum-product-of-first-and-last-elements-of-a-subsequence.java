class Solution {
    public long maximumProduct(int[] nums, int m) {
        long res=Long.MIN_VALUE,min=nums[0],max=nums[0];
        int n=nums.length;
        for(int i=0;i<n;i++){
            int preIndex = i-m+1;
            if(preIndex>=0){
                min=Math.min(min,nums[preIndex]);
                max=Math.max(max,nums[preIndex]);
            }
            if(i>=m-1){
                long a = min*nums[i];
                long b= max*nums[i];
                res=Math.max(res,Math.max(a,b));
            }
        }
        return res;
    }
}