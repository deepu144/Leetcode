class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length, min = (int)1e9, ones =0;
        for(int val : nums) if(val == 1) ones++;
        for(int i=1;i<n;i++){
            int pre = gcd(nums[i],nums[i-1]);
            if(pre == 1){
                min = Math.min(min, n);
                continue;
            }
            for(int j=i+1;j<n;j++){
                pre = gcd(pre,nums[j]);
                if(pre == 1){
                    min = Math.min(min, n+j-i);
                    break;
                }
            }
        }
        if(min == (int)(1e9)) return -1;
        return min-ones;
    }
    public int gcd(int a,int b){
        return b==0 ? a : gcd(b,a%b);
    }
}