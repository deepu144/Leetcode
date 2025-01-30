class Solution {
    public int magnificentSets(int n, int[][] edges) {
        List<Integer>[] adj=new List[n+1];
        for(int i=1;i<=n;i++) adj[i]=new ArrayList<>();
        int sum=0;
        for(int[] a : edges){
            adj[a[0]].add(a[1]);
            adj[a[1]].add(a[0]);
        }
        Set<Integer> set=new HashSet<>();
        DisJointSet ds=new DisJointSet(n+1);
        for(int[] a : edges) ds.union(a[0],a[1]);
        for(int i=1;i<=n;i++){
            int parent=ds.find(i);
            if(set.add(parent)){
                if(ds.size[parent]==1) sum++;
                else{
                    int res=helper(adj,n,parent,ds);
                    if(res==-1) return -1;
                    sum+=res;
                }
            }
        }
        return sum;
    }
    public int helper(List<Integer>[] adj,int n,int parent,DisJointSet ds){
        int maxLevel=(int)(-1e9);
        for(int i=1;i<=n;i++){
            if(ds.find(i)!=parent) continue;
            int res=bfs(i,adj,n);
            if(res==-1) return -1;
            maxLevel=Math.max(maxLevel,res);
        }
        return maxLevel;
    }
    public int bfs(int node,List<Integer>[] adj,int n){
        int[] visited=new int[n+1];
        Queue<Integer> q=new LinkedList<>();
        int level=1;
        q.offer(node);
        visited[node]=level;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int p=q.poll();
                for(int next : adj[p]){
                    if(visited[next]==0){
                        visited[next]=level+1;
                        q.offer(next);
                    }else if(visited[next]==visited[p]) return -1;
                }
            }
            level++;
        }
        return level-1;
    }
}
class DisJointSet{
    int[] parent;
    int[] size;
    public DisJointSet(int n){
        parent=new int[n];
        size=new int[n];
        Arrays.fill(size,1);
        for(int i=0;i<n;i++) parent[i]=i;
    }
    public int find(int u){
        if(parent[u]==u) return u;
        return parent[u]=find(parent[u]);
    }
    public boolean union(int u,int v){
        int ul_u=find(u);
        int ul_v=find(v);
        if(ul_u==ul_v) return false;
        if(size[ul_u]>size[ul_v]){
            parent[ul_v]=ul_u;
            size[ul_u]+=size[ul_v];
        }else{
            parent[ul_u]=ul_v;
            size[ul_v]+=size[ul_u];
        }
        return true;
    }
}