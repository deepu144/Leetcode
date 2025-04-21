class Solution {
    public int minStartValue(int[] nums) {
        int n=nums.length,sum=0,min=sum;
        for(int val : nums){
            sum+=val;
            min=Math.min(sum,min);
        }
        if(min<0) return -min+1;
        return 1;
    }
}