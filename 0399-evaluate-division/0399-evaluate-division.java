class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String,List<Pair>> adj=new HashMap<>();
        for(int i=0;i<equations.size();i++){
            List<String> li=equations.get(i);
            adj.putIfAbsent(li.getFirst(),new ArrayList<>());
            adj.putIfAbsent(li.getLast(),new ArrayList<>());
            adj.get(li.getFirst()).add(new Pair(li.getLast(),values[i]));
            adj.get(li.getLast()).add(new Pair(li.getFirst(),1/values[i]));
        }
        int n=queries.size();
        double[] res=new double[n];
        for(int i=0;i<n;i++){
            List<String> query=queries.get(i);
            if(adj.get(query.getFirst())==null || adj.get(query.getLast())==null){
                res[i]=-1.0;
                continue;
            }
            if(query.getFirst().equals(query.getLast())){
                res[i]=1.0;
                continue;
            }
            res[i]=dfs(adj,query.getFirst(),query.getLast(),new HashSet<>());
            if(res[i]!=-1){
                adj.get(query.getFirst()).add(new Pair(query.getLast(),res[i]));
                adj.get(query.getLast()).add(new Pair(query.getFirst(),1/res[i]));
            }
        }
        return res;
    }
    public Double dfs(Map<String,List<Pair>> adj,String src,String dest,Set<String> visit){
        visit.add(src);
        for(Pair p : adj.get(src)){
            if(p.node.equals(dest)) return p.val;
            if(visit.contains(p.node)) continue;
            double res=dfs(adj,p.node,dest,visit);
            if(res!=-1) return res*p.val;
        }
        return -1.0;
    }
}
class Pair{
    String node;
    Double val;
    Pair(String n,Double va){
        node=n;
        val=va;
    }
}