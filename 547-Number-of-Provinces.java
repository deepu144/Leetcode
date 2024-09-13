class Solution {
    public int findCircleNum(int[][] m) {
        int res=0,n=m.length;
        boolean[] visit = new boolean[n];
        for(int i=0;i<m.length;i++){
            if(!visit[i]){
                res++;
                dfs(visit,m,i,n);
            }
        }
        return res;
    }
    public void dfs(boolean[] visit,int[][] m,int v,int n){
        if(!visit[v]){
            visit[v]=true;
            for(int i=0;i<n;i++){
                if(m[v][i]==1 && !visit[i]){
                    dfs(visit,m,i,n);
                }
            }
        }
    }
}