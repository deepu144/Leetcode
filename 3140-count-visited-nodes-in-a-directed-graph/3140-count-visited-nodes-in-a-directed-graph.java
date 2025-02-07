class Solution {
    public int[] countVisitedNodes(List<Integer> edges) {
        int n=edges.size();
        int[] degree=new int[n];
        int[] res=new int[n];
        for(int u : edges) degree[u]++;
        Queue<Integer> q=new LinkedList<>();
        Set<Integer> noCycleNodes=new HashSet<>();
        List<Integer> zeroInDegree=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(degree[i]==0){
                q.offer(i);
                zeroInDegree.add(i);
            }
        }
        while(!q.isEmpty()){
            int p=q.poll();
            noCycleNodes.add(p);
            degree[edges.get(p)]--;
            if(degree[edges.get(p)]==0) q.offer(edges.get(p));
        }
        for(int i=0;i<n;i++){ 
            if(noCycleNodes.contains(i) || map.containsKey(i)) continue;
            Set<Integer> cycleNodes=new HashSet<>();
            int size=dfs(edges,i,cycleNodes);
            for(int node : cycleNodes) map.put(node,size);
        }
        for(int node : zeroInDegree) dfs(edges,node,map,new Stack<>());
        for(int i=0;i<n;i++) res[i]=map.get(i);
        return res;
    }
    public void dfs(List<Integer> edges,int node,HashMap<Integer,Integer> map,Stack<Integer> st){
        int val=0;
        st.push(node);
        while((val=map.getOrDefault(edges.get(node),-1))==-1){
            node=edges.get(node);
            st.push(node);
        }
        while(!st.isEmpty()){
            map.put(st.pop(),val+1);
            val++;
        }
    }
    public int dfs(List<Integer> edges,int node,Set<Integer> cycleNodes){
        int size=1,src=node;
        cycleNodes.add(src);
        while(edges.get(node)!=src){
            node=edges.get(node);
            cycleNodes.add(node);
            size++;
        }
        return size;
    }
}