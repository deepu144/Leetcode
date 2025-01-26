class Solution {
    public int maximumInvitations(int[] fav) {
        int n=fav.length,size=0;
        int[] depth=new int[n];
        int[] inDegree=new int[n];
        boolean[] visit=new boolean[n];
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++) inDegree[fav[i]]++;
        for(int i=0;i<n;i++) if(inDegree[i]==0) q.offer(i);
        while(!q.isEmpty()){
            int u=q.poll();
            int v=fav[u];
            inDegree[v]--;
            depth[v]=Math.max(depth[v],depth[u]+1);
            if(inDegree[v]==0) q.offer(v);
        }
        int twoPairCycle=0,longestCycle=0;
        for(int i=0;i<n;i++){
            if(inDegree[i]!=0 && !visit[i]){
                int j=i;size=0;
                while(!visit[j]){
                    visit[j]=true;
                    size++;
                    j=fav[j];
                }
                if(size==2) twoPairCycle+=depth[i]+depth[fav[i]]+size;
                else longestCycle=Math.max(longestCycle,size);
            }
        }
        return Math.max(longestCycle,twoPairCycle);
    }
}