class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int n=s1.length(),m=baseStr.length();
        DisJointSet ds=new DisJointSet(26);
        StringBuilder sb=new StringBuilder();
        int[] min=new int[26];
        for(int i=0;i<26;i++) min[i]=i;
        for(int i=0;i<n;i++){
            int c1=s1.charAt(i)-'a';
            int c2=s2.charAt(i)-'a';
            ds.union(c1,c2);
        }
        for(int i=0;i<n;i++){
            helper(s1.charAt(i),ds,min);
            helper(s2.charAt(i),ds,min);
        }
        for(int i=0;i<m;i++){
            char ch=baseStr.charAt(i);
            int ul_u = ds.find(ch-'a');
            sb.append((char)(min[ul_u]+'a'));
        }
        return sb.toString();
    }
    public void helper(char ch,DisJointSet ds,int[] min){
        int ul_u=ds.find(ch-'a');
        min[ul_u]=Math.min(min[ul_u],ch-'a');
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