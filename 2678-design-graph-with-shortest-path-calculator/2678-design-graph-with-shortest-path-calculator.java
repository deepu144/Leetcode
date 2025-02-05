class Graph {
    int[][] dist;
    int n;
    public Graph(int n, int[][] edges) {
        this.n=n;
        dist=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
            dist[i][i]=0;
        }
        for(int[] edge : edges) dist[edge[0]][edge[1]]=edge[2];
        calculateDistance(dist);
    }

    public void calculateDistance(int[][] dist){
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                if(dist[i][k]==Integer.MAX_VALUE) continue;
                for(int j=0;j<n;j++){
                    if(dist[k][j]==Integer.MAX_VALUE) continue;
                    dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                }
            }
        }
    }
    
    public void addEdge(int[] edge) {
        if(dist[edge[0]][edge[1]]<=edge[2]) return;
        dist[edge[0]][edge[1]]=edge[2];
        calculateDistance(dist);
    }
    
    public int shortestPath(int node1, int node2) {
        return dist[node1][node2]==Integer.MAX_VALUE?-1:dist[node1][node2];
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */