class Solution {
    public long minCost(int[] arr, int[] brr, long k) {
        int n = arr.length;
        long ans1 = 0;
        long ans2 = 0;
        for(int i=0;i<n;i++){
            ans1 += Math.abs(arr[i]-brr[i]);
        }
        Arrays.sort(arr);
        Arrays.sort(brr);
        for(int i=0;i<n;i++){
            ans2 += Math.abs(arr[i]-brr[i]);
        }
        return Math.min(ans1,ans2 + k);
    }
}