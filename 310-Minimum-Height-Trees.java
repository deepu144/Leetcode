class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1 && edges.length==0) return List.of(0);
        List<Integer> li=new ArrayList<>();
        List<Integer>[] adj=new List[n];
        for(int i=0;i<n;i++) adj[i]=new ArrayList<>();
        int[] degree=new int[n];
        int t=n;
        for(int[] a : edges){
            adj[a[0]].add(a[1]);
            adj[a[1]].add(a[0]);
            degree[a[0]]++;
            degree[a[1]]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++) if(degree[i]==1) q.offer(i);
        while(t>2){
            int size=q.size();
            for(int i=0;i<size;i++){
                int p=q.poll();
                for(int v : adj[p]){
                    degree[v]--;
                    if(degree[v]==1) q.offer(v);
                }
                t--;
            }
        }
        while(!q.isEmpty()) li.add(q.poll());
        return li;
    }
}