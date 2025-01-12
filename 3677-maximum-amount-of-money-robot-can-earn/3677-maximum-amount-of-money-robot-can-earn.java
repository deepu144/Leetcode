class Solution {
    int[][] dir={{0,-1},{-1,0}};
    public int maximumAmount(int[][] coins) {
        int r=coins.length,c=coins[0].length;
        if(r==1 && c==1 && coins[0][0]<0) return 0;
        if(r==1 && c==2 && coins[0][0]<0 && coins[0][1]<0) return 0;
        if(r==2 && c==1 && coins[0][0]<0 && coins[1][0]<0) return 0;
        return dfs(coins,r,c,r-1,c-1,2,new Integer[r+1][c+1][3]);
    }
    public int dfs(int[][] coins,int r,int c,int i,int j,int k,Integer[][][] dp){
        if(i==0 && j==0) return coins[i][j]<0 ? k>0?0:coins[i][j] : coins[i][j];
        if(i<0 || j<0) return (int)(-1e8);
        if(dp[i][j][k]!=null) return dp[i][j][k];
        int max1=(int)(-1e9),max2=(int)(-1e9);
        for(int[] a : dir){
            int x=a[0]+i;
            int y=a[1]+j;
            if(x<0||y<0||x>=r||y>=c) continue;
            if(coins[i][j]<0 && k>0) max1=Math.max(max1,dfs(coins,r,c,x,y,k-1,dp));
            max2=Math.max(max2,coins[i][j]+dfs(coins,r,c,x,y,k,dp));
        }
        return dp[i][j][k]=Math.max(max1,max2);
    }
}