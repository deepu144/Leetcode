class Solution {
    final int MOD=(int)(1e9+7);
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        final int n=nums.length;
        int[] sweep=new int[n+1];
        for(int[] a : requests){
            sweep[a[0]]++;
            sweep[a[1]+1]--;
        }
        for(int i=1;i<=n;i++) sweep[i]+=sweep[i-1];
        Arrays.sort(nums);
        Arrays.sort(sweep);
        long res=0;
        for(int i=0;i<n;i++) res+=(long)nums[i]*sweep[i+1];
        return (int)(res%MOD);
    }
}