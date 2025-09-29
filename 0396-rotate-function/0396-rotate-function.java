class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length,max=0,prod=0,sum=0,k=n-1;
        for(int i=0;i<n;i++){
            prod += (i*nums[i]);
            if(i!=n-1) sum+=nums[i];
        }
        max=prod;
        for(int i=0;i<n-1;i++){
            prod = prod + sum - ((n-1) * nums[k]);
            max = Math.max(max,prod);
            sum += (nums[k] - nums[k-1]);
            k--;
        }
        return max;
    }
}