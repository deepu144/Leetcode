class Solution {
    public int st=1;
    public long maxScore(int n, int[][] edges) {
        long ans=0L;
        DisJointSet ds=new DisJointSet(n);
        boolean[] cycle=new boolean[n];
        for(int[] edge : edges){
            if(!ds.union(edge[0],edge[1])){
                int ul_u=ds.find(edge[0]);
                cycle[ul_u]=true;
            }
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<n;i++){
            if(!cycle[i] && ds.parent[i]==i) pq.offer(ds.size[i]);
        }
        ans+=calculateWithNoCycle(pq);
        ans+=calculateWithCycle(cycle,n,ds);
        return ans;
    }

    public long calculateWithCycle(boolean[] cycle,int n,DisJointSet ds){
        long sum=0L;
        for(int i=0;i<n;i++){
            if(cycle[i]){
                sum+=helper(ds.size[i]);
                sum+=((long)st*(st+1));
                st+=ds.size[i];
            }
        }
        return sum;
    }

    public long calculateWithNoCycle(PriorityQueue<Integer> pq){
        long sum=0L;
        while(!pq.isEmpty()){
            int size=pq.poll();
            if(size==1){
                st++;
                continue;
            }
            sum+=helper(size);
            st+=size;
        }
        return sum;
    }
    public long helper(int n){
        long sum=0L;
        int prevOdd=-1,prevEven=-1;
        for(int i=st;i<st+n;i++){
            if((i&1)==1){
                if(prevOdd!=-1) sum+=((long)prevOdd*i);
                prevOdd=i;
            }else{
                if(prevEven!=-1) sum+=((long)prevEven*i);
                prevEven=i;
            }
        }
        int end=st+n-1;
        return sum+((long)end*(end-1));
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