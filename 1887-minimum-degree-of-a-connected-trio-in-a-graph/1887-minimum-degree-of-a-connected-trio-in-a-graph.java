class Solution {
    public int minTrioDegree(int n, int[][] edges) {
        boolean[][] adj=new boolean[n+1][n+1];
        int[] degree=new int[n+1];
        for(int[] a : edges){
            adj[a[0]][a[1]]=adj[a[1]][a[0]]=true;
            degree[a[0]]++;
            degree[a[1]]++;
        }
        int min=(int)(1e9);
        boolean found=false;
        for(int u=1;u<=n;u++){
            for(int v=u+1;v<=n;v++){
                if(adj[u][v]){
                    for(int w=v+1;w<=n;w++){
                        if(adj[u][w] && adj[v][w]){
                            found=true;
                            min=Math.min(min,degree[u]+degree[v]+degree[w]-6);
                        }
                    }
                }
            }
        }
        if(found) return min;
        return -1;
    }
}