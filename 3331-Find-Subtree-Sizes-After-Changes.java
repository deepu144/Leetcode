class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n=parent.length;
        List<Integer>[] adj=new List[n];
        for(int i=0;i<n;i++) adj[i]=new ArrayList<>();
        for(int i=1;i<n;i++) adj[parent[i]].add(i);
        int[] size=new int[n];
        int[] hash=new int[26];
        Arrays.fill(size,1);
        Arrays.fill(hash,-1);
        dfs(0,adj,-1,size,hash,s);
        return size;
    }
    public void dfs(int v,List<Integer>[] adj,int parent,int[] size,int[] hash,String s){
        char ch=s.charAt(v);
        int temp=hash[ch-'a'];
        hash[ch-'a']=v;
        for(int i : adj[v]){
            dfs(i,adj,v,size,hash,s);
        }
        hash[ch-'a']=temp;
        if(hash[ch-'a']!=-1){
            size[hash[ch-'a']]+=size[v];
        }else{
            if(parent==-1) return;
            size[parent]+=size[v];
        }
    }
}