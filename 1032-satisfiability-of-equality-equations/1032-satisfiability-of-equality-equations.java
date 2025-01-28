class Solution {
    public boolean equationsPossible(String[] equations) {
        DisJointSet ds=new DisJointSet(26);
        for(String s : equations){
            int a=s.charAt(0)-'a';
            int b=s.charAt(3)-'a';
            int ul_u=ds.find(a);
            int ul_v=ds.find(b);
            if(s.charAt(1)=='=') ds.union(ul_u,ul_v);
        }
        for(String s : equations){
            int a=s.charAt(0)-'a';
            int b=s.charAt(3)-'a';
            int ul_u=ds.find(a);
            int ul_v=ds.find(b);
            if(s.charAt(1)=='!' && ul_u==ul_v) return false;
        }
        return true;
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
        if(size[u]>size[v]){
            parent[v]=u;
            size[u]+=size[v];
        }else{
            parent[u]=v;
            size[v]+=size[u];
        }
        return true;
    }
}