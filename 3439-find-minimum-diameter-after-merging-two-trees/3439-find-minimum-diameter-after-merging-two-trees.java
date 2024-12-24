class Solution {
    final String COMMA=",";
    int tree1=0,tree2=0;
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        if(edges1.length==0 && edges2.length==0) return 1;
        List<Integer>[] adj1=getAdjacentList(edges1);
        List<Integer>[] adj2=getAdjacentList(edges2);
        int max1=adj1.length,max2=adj2.length;
        if(edges1.length!=0) diameter(adj1,0,-1,true);
        if(edges2.length!=0) diameter(adj2,0,-1,false);
        int t1= tree1>=2?tree1%2==0?(tree1/2):(tree1/2)+1:tree1;
        int t2= tree2>=2?tree2%2==0?(tree2/2):(tree2/2)+1:tree2;
        if(t1+t2+1<tree1)return tree1;
        if(t1+t2+1<tree2) return tree2;
        return t1+t2+1;
    }
    public int diameter(List<Integer>[] adj,int node,int parent,boolean isFirstTree){
        if(adj[node].size()==1 && adj[node].getFirst()==parent){
            return 0;
        }
        int max1=0,max2=0;
        for(int n : adj[node]){
            if(n!=parent){
                int t=1+diameter(adj,n,node,isFirstTree);
                if(t>max1){
                    max2=max1;
                    max1=t;
                }else if(t>max2) max2=t;
            }
        }
        if(isFirstTree) tree1= Math.max(tree1,max1+max2);
        else tree2=Math.max(max1+max2,tree2);
        return max1;
    }
    public List<Integer>[] getAdjacentList(int[][] edges){
        int max=-1;
        for(int[] a : edges) max=Math.max(a[0],Math.max(max,a[1]));
        List<Integer>[] adj=new List[max+1];
        for(int i=0;i<=max;i++) adj[i]=new ArrayList<>();
        for(int[] a : edges){
            adj[a[0]].add(a[1]);
            adj[a[1]].add(a[0]);
        }
        return adj;
    }
}