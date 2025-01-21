class Solution {
    public long gridGame(int[][] grid) {
        int n=grid[0].length;
        long[] prefixZero=new long[n];
        long[] prefixOne=new long[n+1];
        long sum1=0,sum2=0;
        for(int i=0;i<n;i++){
            sum1+=grid[0][i];
            prefixZero[i]=sum1;
            sum2+=grid[1][i];
            prefixOne[i+1]=sum2;
        }
        long max=Long.MAX_VALUE;
        for(int i=0;i<n;i++){
            long leftZero=prefixZero[n-1]-prefixZero[i];
            long rightOne=prefixOne[i];
            max=Math.min(max,Math.max(leftZero,rightOne));
        }
        return max;
    }
}