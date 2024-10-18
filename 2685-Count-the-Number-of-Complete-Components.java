class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer>[] adj=new List[n];
        for(int i=0;i<n;i++) adj[i]=new ArrayList<>();
        int[] degree=new int[n];
        for(int[] a : edges){
            adj[a[0]].add(a[1]);
            adj[a[1]].add(a[0]);
            degree[a[0]]++;
            degree[a[1]]++;
        }
        int com=0;
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++){
            if(adj[i].isEmpty()) com++;
            else if(!visited[i]) {
                List<Integer> li=new ArrayList<>();
                dfs(i,adj,visited,li);
                int deg=li.size()-1,f=1;
                for(int j=1;j<li.size();j++){
                    if(degree[li.get(j)]!=deg){
                        f=0;
                        break;
                    }
                }
                if(f==0) continue;
                com++;
            }
        }
        return com;
    }
    public void dfs(int v,List<Integer>[] adj,boolean[] visited,List<Integer> li){
        visited[v]=true;
        li.add(v);
        for(int i : adj[v]){
            if(!visited[i]) dfs(i,adj,visited,li);
        }
    }
}