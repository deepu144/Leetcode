class Solution {
    public long gridGame(int[][] grid) {
        int n=grid[0].length;
        long[] suffixZero=new long[n+1];
        long[] prefixOne=new long[n+1];
        for(int i=1;i<=n;i++){
            prefixOne[i]=prefixOne[i-1]+grid[1][i-1];
            suffixZero[n-i]=suffixZero[n-i+1]+grid[0][n-i];          
        }
        long max=Long.MAX_VALUE;
        for(int i=0;i<n;i++){
            long leftZero=suffixZero[i+1];
            long rightOne=prefixOne[i];
            max=Math.min(max,Math.max(leftZero,rightOne));
        }
        return max;
    }
}