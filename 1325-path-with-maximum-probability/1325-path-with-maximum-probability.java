class Solution {
    record Pair(int u,double prob){}
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Double.compare(b.prob,a.prob));
        List<Pair>[] adj=new List[n];
        double[] maxProb=new double[n];
        for(int i=0;i<n;i++) adj[i]=new ArrayList<>();
        for(int i=0;i<edges.length;i++){
            int[] edge=edges[i];
            adj[edge[0]].add(new Pair(edge[1],succProb[i]));
            adj[edge[1]].add(new Pair(edge[0],succProb[i]));
        }
        pq.offer(new Pair(start_node,1.0));
        maxProb[start_node]=1.0;
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            if(p.u==end_node) return p.prob;
            for(Pair node : adj[p.u]){
                double mul=p.prob*node.prob;
                if(mul>maxProb[node.u]){
                    pq.offer(new Pair(node.u,mul));
                    maxProb[node.u]=mul;
                }
            }
        }
        return 0.0;
    }
}