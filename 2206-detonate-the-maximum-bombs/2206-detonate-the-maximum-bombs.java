class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n=bombs.length;
        List<Integer>[] adj=new List[n];
        for(int i=0;i<n;i++) adj[i]=new ArrayList<>();
        for(int i=0;i<n;i++){
            int[] point1=bombs[i];
            for(int j=i+1;j<n;j++){
                int[] point2=bombs[j];
                long dist=distance(point1[0],point1[1],point2[0],point2[1]);
                if(dist<=(long)point1[2]*point1[2]) adj[i].add(j);
                if(dist<=(long)point2[2]*point2[2]) adj[j].add(i);
            }
        }
        int max=0;
        boolean[] visit=new boolean[n];
        for(int i=0;i<n;i++) max=Math.max(max,dfs(adj,i,new boolean[n]));
        return max;
    }
    public int dfs(List<Integer>[] adj,int node,boolean[] visit){
        if(visit[node]) return 0;
        visit[node]=true;
        int sum=1;
        for(int n : adj[node]) sum+=dfs(adj,n,visit);
        return sum;
    }
    public long distance(int x1,int y1,int x2,int y2){
        long a=x2-x1,b=y2-y1;
        a*=a;b*=b;
        return a+b;
    }
}