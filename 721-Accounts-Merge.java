class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String,Integer> map = new HashMap<>();
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String s = accounts.get(i).get(j);
                if(map.containsKey(s)) ds.union(i,map.get(s));
                else map.put(s,i);
            }
        }
        List<List<String>> li = new ArrayList<>();
        for(int i=0;i<n;i++) li.add(new ArrayList<>());
        for(Map.Entry<String,Integer> m : map.entrySet()){
            int parent = ds.find(m.getValue());
            li.get(parent).add(m.getKey());
        }
        List<List<String>> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(li.get(i).isEmpty()) continue;
            ArrayList<String> t = new ArrayList<>();
            int parent = ds.find(map.get(li.get(i).getFirst()));
            for(String s : li.get(i)){
                t.add(s);
            }
            Collections.sort(t);
            t.addFirst(accounts.get(parent).getFirst());
            ans.add(t);
        }
        return ans;
    }
}
class DisjointSet{
    int[] parent;
    int[] size;
    
    DisjointSet(int n){
        parent=new int[n];
        size=new int[n];
        Arrays.fill(size,1);
        for(int i=0;i<n;i++) parent[i]=i;
    }
    
    int find(int v){
        if(parent[v]==v) return v;
        return parent[v] = find(parent[v]);
    }
    
    void union(int u,int v){
        int ul_u = find(u);
        int ul_v = find(v);
        if(ul_u == ul_v) return;
        if(size[ul_u]<size[ul_v]){
            parent[ul_u]=ul_v;
            size[ul_v]+=size[ul_u];
        }else{
            parent[ul_v]=ul_u;
            size[ul_u]+=size[ul_v];
        }
    }
}