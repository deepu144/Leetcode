class Solution {
    final String COMMA=",";
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        List<Integer>[] adj1=getAdjacentList(edges1);
        List<Integer>[] adj2=getAdjacentList(edges2);
        int max1=adj1.length,max2=adj2.length,tree1=0,tree2=0;
        // Integer[][] dp1= new Integer[max1][max1+1];
        // Integer[][] dp2= new Integer[max2][max2+1];
        HashMap<String,Integer> dp1=new HashMap<>();
        HashMap<String,Integer> dp2=new HashMap<>();
        for(int i=0;i<max1;i++){
            if(adj1[i].size()==1){
                tree1=Math.max(tree1,dfs(adj1,i,-1,dp1));
            }
        }
        for(int i=0;i<max2;i++){
            if(adj2[i].size()==1){
                tree2=Math.max(tree2,dfs(adj2,i,-1,dp2));
            }
        }
        int t1= tree1>=2?tree1%2==0?(tree1/2):(tree1/2)+1:tree1;
        int t2= tree2>=2?tree2%2==0?(tree2/2):(tree2/2)+1:tree2;
        if(t1+t2+1<tree1)return tree1;
        if(t1+t2+1<tree2) return tree2;
        return t1+t2+1;
    }
    public int dfs(List<Integer>[] adj,int node,int parent,HashMap<String,Integer> dp){
        if(adj[node].size()==1 && adj[node].getFirst()==parent){
            return 0;
        }
        String s=node+COMMA+parent;
        if(dp.containsKey(s)) return dp.get(s);
        int max=-1;
        for(int n : adj[node]){
            if(n!=parent) max=Math.max(max,1+dfs(adj,n,node,dp));
        }
        dp.put(s,max);
        return max;
    }
    public List<Integer>[] getAdjacentList(int[][] edges){
        int max=-1;
        for(int[] a : edges) max=Math.max(a[0],Math.max(max,a[1]));
        List<Integer>[] adj=new List[max+1];
        for(int i=0;i<=max;i++) adj[i]=new ArrayList<>();
        for(int[] a : edges){
            adj[a[0]].add(a[1]);
            adj[a[1]].add(a[0]);
        }
        return adj;
    }
}