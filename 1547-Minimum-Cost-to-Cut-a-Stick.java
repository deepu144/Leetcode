class Solution {
    public int minCost(int n, int[] cuts) {
        int t=cuts.length;
        int[] arr=new int[t+2];
        arr[t+1]=n;
        for(int i=1;i<t+1;i++) arr[i]=cuts[i-1];
        Arrays.sort(arr);
        int[][] dp=new int[t+2][t+2];
        for(int i=t;i>=1;i--){
            for(int j=1;j<=t;j++){
                if(i>j) continue;
                int min=(int)(1e9);
                for(int ind=i;ind<=j;ind++){
                    int res = arr[j+1]-arr[i-1]+dp[i][ind-1]+dp[ind+1][j];
                    min=Math.min(min,res);
                }
                dp[i][j]=min;
            }
        }
        return dp[1][t];
    }
}