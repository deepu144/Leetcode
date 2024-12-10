class Solution {
    int max=-1;
    public int longestPath(int[] parent, String s) {
        int n=parent.length,root=0;
        List<Integer>[] adj=new List[n];
        for(int i=0;i<n;i++) adj[i]=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(parent[i]==-1){
                root=i;
                continue;
            }
            adj[i].add(parent[i]);
            adj[parent[i]].add(i);
        }
        dfs(adj,root,s.charAt(root),-1,s);
        return max;
    }
    public int dfs(List<Integer>[] adj,int node,char pre,int parent,String s){
        char ch=s.charAt(node);
        if(adj[node].size()==1 && adj[node].getFirst()==parent){
            return pre==ch?0:1;
        }
        int len=0;
        List<Integer> li=new ArrayList<>();
        for(int n : adj[node]){
            if(n!=parent) li.add(dfs(adj,n,ch,node,s));
        }
        Collections.sort(li,Comparator.reverseOrder());
        int t=0;
        while(t<2 && t<li.size()) len+=li.get(t++);
        max=Math.max(len+1,max);
        return pre==ch?0:li.get(0)+1;
    }
}