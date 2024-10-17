class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n=graph.length;
        dfs(0,n-1,graph,new ArrayList<>(List.of(0)));
        return res;
    }
    public void dfs(int v,int dest,int[][] graph,List<Integer> path){
        if(v==dest){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i : graph[v]){
            path.add(i);
            dfs(i,dest,graph,path);
            path.removeLast();
        }
    }
}