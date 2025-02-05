class Solution {
    public int shortestPathLength(int[][] graph) {
        int n=graph.length;
        int[][] dist=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
            dist[i][i]=0;
        }
        for(int i=0;i<n;i++) for(int v : graph[i]) dist[i][v]=1;
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dist[i][k]==Integer.MAX_VALUE || dist[k][j]==Integer.MAX_VALUE) continue;
                    dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                }
            }
        }
        int min=(int)(1e9),mask=0,m=(1<<n);
        for(int i=0;i<n;i++){
            mask^=(1<<i);
            min=Math.min(min,dfs(dist,i,mask,n,new Integer[n][m]));
            mask^=(1<<i);
        }
        return min;
    }
    public int dfs(int[][] dist,int u,int mask,int n,Integer[][] dp){
        if(dp[u][mask]!=null) return dp[u][mask];
        int min=(int)(1e9);
        for(int i=0;i<n;i++){
            if((mask&(1<<i))==0){
                mask^=(1<<i);
                int pathSum=dist[u][i]+dfs(dist,i,mask,n,dp);
                min=Math.min(min,pathSum);
                mask^=(1<<i);
            }
        }
        return dp[u][mask]=(min==(1e9)?0:min);
    }
}