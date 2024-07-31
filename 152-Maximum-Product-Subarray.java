class Solution {
    public int maxProduct(int[] nums) {
        double max=Integer.MIN_VALUE;
        double sum=1;
        double b=1;
        int n = nums.length;
        for(int i=0;i<n;i++){
            sum*=nums[i];
            b*=nums[n-1-i];
            max=Math.max(max,Math.max(sum,b));
            if(sum==0)
                sum=1;
            if(b==0)
                b=1;
        }
        return (int)max;
    }
}