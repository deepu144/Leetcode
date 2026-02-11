class Solution {
    public int waysToMakeFair(int[] nums) {
        int n = nums.length, oddSum = 0, evenSum = 0, cnt = 0;
        int[] suffixEvenSum = getSum(nums, n, 0);
        int[] suffixOddSum = getSum(nums, n, 1);

        for(int i=0;i<n-1;i++){
            int a = oddSum + suffixEvenSum[i+1];
            int b = evenSum + suffixOddSum[i+1];
            if((i & 1) == 0) evenSum += nums[i];
            else oddSum += nums[i];
            if(a == b) cnt++;
        }
        if(oddSum == evenSum) cnt++;
        return cnt;
    }
    public int[] getSum(int[] nums,int n, int flag) {
        int sum = 0;
        int[] suffixSum = new int[n];
        for(int i=n-1; i >= 1; i--){
            if((i & 1) == flag) sum += nums[i];
            suffixSum[i] = sum;
        }
        return suffixSum;
    }
}