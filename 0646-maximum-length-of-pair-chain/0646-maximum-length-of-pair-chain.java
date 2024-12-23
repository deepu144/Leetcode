class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        int max=0,n=pairs.length;
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(pairs[i][0]>pairs[j][1]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}