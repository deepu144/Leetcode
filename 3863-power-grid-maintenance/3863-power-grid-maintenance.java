class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        DisJointSet ds = new DisJointSet(c+1);
        int components = 0, m=0, j=0;
        for(int[] q : queries) if(q[0]==1) m++;
        boolean[] isOnline = new boolean[c+1];
        int[] res = new int[m];
        for(int[] connection : connections) ds.union(connection[0],connection[1]);
        for(int i=1;i<=c;i++){
            if(ds.parent[i]==i) components++;
            isOnline[i]=true;
        }
        PriorityQueue<Integer>[] pq = new PriorityQueue[components];
        for(int i=0;i<components;i++) pq[i] = new PriorityQueue<>();
        Map<Integer,Integer> pqIndex = new HashMap<>();
        for(int i=1;i<=c;i++){
            int ul_i = ds.find(i);
            int idx = pqIndex.getOrDefault(ul_i,-1);
            if(idx == -1) {
                idx = j++;
                pqIndex.put(ul_i,idx);
            }
            pq[idx].offer(i);
        }
        j=0;
        for(int[] query : queries){
            if(query[0]==2) isOnline[query[1]]=false;
            else{
                int ans = query[1];
                if(!isOnline[query[1]]){
                    int idx = pqIndex.get(ds.find(query[1]));
                    while(!pq[idx].isEmpty() && !isOnline[pq[idx].peek()]) pq[idx].poll();
                    if(pq[idx].isEmpty()) ans = -1;
                    else ans = pq[idx].peek();
                }
                res[j++] = ans;
            }
        }
        return res;
    }
}

class DisJointSet{
    int n;
    int[] size;
    int[] parent;
    public DisJointSet(int n){
        this.n = n;
        this.size = new int[n];
        this.parent = new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
    }
    public int find(int u){
        if(parent[u]==u) return u;
        return find(parent[u]);
    }
    public boolean union(int u,int v){
        int ul_u = find(u);
        int ul_v = find(v);
        if(ul_u == ul_v) return false;

        if(size[ul_u] > size[ul_v]){
            parent[ul_v] = ul_u;
            size[ul_u] += size[ul_v];
        }else{
            parent[ul_u] = ul_v;
            size[ul_v] += size[ul_u];
        }
        return true;
    }
}