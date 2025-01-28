class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<Set<Integer>> parent=new ArrayList<>();
        List<Integer>[] adj=new List[n];
        for(int i=0;i<n;i++) adj[i]=new ArrayList<>();
        for(int i=0;i<n;i++) parent.add(new HashSet<>());
        int[] inDegree=new int[n];
        for(int[] a : edges){
            inDegree[a[1]]++;
            adj[a[0]].add(a[1]);
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++) if(inDegree[i]==0) q.add(i);
        while(!q.isEmpty()){
            int p=q.poll();
            for(int node : adj[p]){
                parent.get(node).addAll(parent.get(p));
                parent.get(node).add(p);
                inDegree[node]--;
                if(inDegree[node]==0) q.offer(node);
            }
        }
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<n;i++){
            res.add(new ArrayList<>(parent.get(i)));
            Collections.sort(res.get(i));
        }
        return res;
    }
}