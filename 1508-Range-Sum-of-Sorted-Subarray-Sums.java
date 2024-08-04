class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int prefixSum = 0;
        int ans [] = new int[n*(n + 1)/2];
        int k = 0;
        long sum = 0;
        for(int i=0;i<n;i++){
            prefixSum = 0;
            for(int j=i;j<n;j++){
                prefixSum += nums[j];
                ans[k++] = prefixSum;
            }
        }
        Arrays.sort(ans);
        for(int i=left-1;i<right;i++){
            sum += ans[i];
        }
        sum = sum % 1000000007;
        return (int)sum;
    }
}