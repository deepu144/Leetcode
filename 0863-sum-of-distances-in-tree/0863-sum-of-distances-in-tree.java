class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges){
        List<Integer>[] adj=new List[n];
        for(int i=0;i<n;i++) adj[i]=new ArrayList<>();
        for(int[] edge : edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        int[] res=new int[n];
        int[] child=new int[n];
        res[0]=bfs(adj,0);//finding answer for one node
        dfs(adj,child,0,-1);//finding childs count
        dfs(adj,child,0,-1,res,n);//apply re-rooting technique 
        return res;
    }
    public void dfs(List<Integer>[] adj,int[] child,int node,int parent,int[] res,int n){
        if(parent!=-1) res[node]=res[parent]+(n-child[node])-(child[node]);
        for(int neighbour : adj[node]){
            if(neighbour==parent) continue;
            dfs(adj,child,neighbour,node,res,n);
        }
    }
    public int dfs(List<Integer>[] adj,int[] child,int node,int parent){
        if(adj[node].size()==1 && adj[node].getFirst()==parent) return child[node]=1;
        for(int neighbour : adj[node]){
            if(neighbour==parent) continue;
            child[node]+=dfs(adj,child,neighbour,node);
        }
        return child[node]+=1;
    }
    public int bfs(List<Integer>[] adj,int n){
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{n,-1}); // {node,parent}
        int level=0,dist=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] node=q.poll();
                for(int neighbour : adj[node[0]]){
                    if(neighbour==node[1]) continue;
                    q.offer(new int[]{neighbour,node[0]});
                }
            }
            dist+=(level*size);
            level++;
        }
        return dist;
    }
}