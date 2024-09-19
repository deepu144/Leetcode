class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();
        int v=graph.length;
        int[] inDegree = new int[v];
        for(int i=0;i<v;i++){
            adj.add(new ArrayList());
        }
        for(int i=0;i<v;i++){
            for(int n : graph[i]){
                adj.get(n).add(i);
                inDegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<v;i++){
            if(inDegree[i]==0){
                q.offer(i);
            }
        }
        List<Integer> res=new ArrayList<>();
        int j=0;
        while(!q.isEmpty()){
            int n=q.poll();
            res.add(n);
            for(int i : adj.get(n)){
                inDegree[i]--;
                if(inDegree[i]==0) q.offer(i);
            }
        }
        Collections.sort(res);
        return res;
    }
}