class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        int components=0,temp=0;
        DisJointSet ds=new DisJointSet(c+1);
        HashMap<Integer,Integer> map=new HashMap<>();
        boolean[] isOffline=new boolean[c+1];
        for(int[] a : connections) ds.union(a[0],a[1]);
        for(int i=1;i<=c;i++){
            int ul_u = ds.find(i);
            if(ul_u==i) components++;
            if(!map.containsKey(ul_u)) map.put(ul_u,temp++);
        }
        TreeSet[] set=new TreeSet[components];
        for(int i=0;i<components;i++) set[i]=new TreeSet();
        for(int i=1;i<=c;i++){
            int ul_u = ds.find(i);
            int index = map.get(ul_u);
            set[index].add(i);
        }
        temp=0;
        for(int[] a : queries) if(a[0]==1) temp++;
        int[] res=new int[temp];
        temp=0;
        for(int[] a : queries){
            int index = map.get(ds.find(a[1]));
            if(a[0]==1){
                if(set[index].isEmpty()) res[temp]=-1;
                else{
                    if(isOffline[a[1]]) res[temp]=(int)set[index].getFirst();
                    else res[temp]=a[1];
                }
                temp++;
            }else{
                set[index].remove(a[1]);
                isOffline[a[1]]=true;
            }
        }
        return res;
    }
}
class DisJointSet{
    int[] parent;
    int[] size;
    public DisJointSet(int n){
        parent=new int[n];
        size=new int[n];
        Arrays.fill(size,1);
        for(int i=0;i<n;i++) parent[i]=i;
    }
    public int find(int u){
        if(parent[u]==u) return u;
        return parent[u]=find(parent[u]);
    }
    public boolean union(int u,int v){
        int ul_u=find(u);
        int ul_v=find(v);
        if(ul_u==ul_v) return false;
        if(size[ul_u]>size[ul_v]){
            parent[ul_v]=ul_u;
            size[ul_u]+=size[ul_v];
        }else{
            parent[ul_u]=ul_v;
            size[ul_v]+=size[ul_u];
        }
        return true;
    }
}