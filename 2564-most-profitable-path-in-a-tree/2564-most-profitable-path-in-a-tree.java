class Solution {
    int max=(int)(-1e9);
    public int mostProfitablePath(int[][] edges, int bob, int[] amount){
        int n=amount.length,alice=0;
        Queue<int[]> q=new LinkedList<>();
        byte[] visited=new byte[n]; 
        List<Integer>[] adj=new List[n];
        for(int i=0;i<n;i++) adj[i]=new ArrayList<>();
        for(int[] edge : edges){
            int u=edge[0],v=edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }
        List<Integer> bobSteps=new ArrayList<>();
        dfs(adj,bob,-1,0,bobSteps);
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<bobSteps.size();i++) map.put(bobSteps.get(i),i);
        dfs(adj,0,-1,0,0,amount,map);
        return max;
    }
    public void dfs(List<Integer>[] adj,int node,int parent,int step,int alice,int[] amount,Map<Integer,Integer> map){
        if(adj[node].size()==1 && adj[node].getFirst()==parent){
            int t=map.getOrDefault(node,-1);
            if(t==-1 || step<t) alice+=amount[node];
            else if(step==t) alice+=(amount[node]/2);
            max=Math.max(max,alice);
            return;
        }
        for(int neighbour : adj[node]){
            if(neighbour==parent) continue;
            int t=map.getOrDefault(node,-1);
            if(t==-1 || step<t) dfs(adj,neighbour,node,step+1,alice+amount[node],amount,map);
            else if(step==t) dfs(adj,neighbour,node,step+1,alice+(amount[node]/2),amount,map);
            else if(step>t) dfs(adj,neighbour,node,step+1,alice,amount,map);
        }
    }
    public boolean dfs(List<Integer>[] adj,int node,int parent,int dest,List<Integer> bobSteps){
        bobSteps.add(node);
        if(node==dest) return true;
        for(int neighbour : adj[node]){
            if(neighbour==parent) continue;
            if(dfs(adj,neighbour,node,dest,bobSteps)) return true;
        }
        bobSteps.removeLast();
        return false;
    }
}