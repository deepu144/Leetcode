class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] arr) {
        List<Integer>[] adj=new List[n];
        for(int i=0;i<n;i++) adj[i]=new ArrayList<>();
        for(int[] a : arr) adj[a[0]].add(a[1]);
        boolean[] visited=new boolean[n];
        dfs(k,adj,visited);
        boolean check=true;
        for(int i=0;i<n;i++){
            if(visited[i]) continue;
            for(int v : adj[i]){
                if(visited[v]){
                    check=false;
                    break;
                }
            }
            if(!check) break;
        }
        List<Integer> ans=new ArrayList<>();
        if(!check){
            for(int i=0;i<n;i++) ans.add(i);
            return ans;
        }else{
            for(int i=0;i<n;i++) if(!visited[i]) ans.add(i);
            return ans;
        }
    }
    public void dfs(int v,List<Integer>[] adj,boolean[] visited){
        visited[v]=true;
        for(int i : adj[v]){
            if(!visited[i]) dfs(i,adj,visited);
        }
    }
}