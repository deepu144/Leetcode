class Solution {
    public static long INF=Long.MAX_VALUE;
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long[][] dist=new long[26][26];
        for(int i=0;i<26;i++){
            Arrays.fill(dist[i],INF);
            dist[i][i]=0L;
        }
        int n=original.length,m=source.length();
        long res=0L;
        for(int i=0;i<n;i++){
            int u=original[i]-'a';
            int v=changed[i]-'a';
            dist[u][v]=Math.min(dist[u][v],(long)cost[i]);
        }
        for(int k=0;k<26;k++){
            for(int i=0;i<26;i++){
                for(int j=0;j<26;j++){
                    if(dist[i][k]==INF || dist[k][j]==INF) continue;
                    dist[i][j]=Math.min(dist[i][j],(long)dist[i][k]+dist[k][j]);
                }
            }
        }
        for(int i=0;i<m;i++){
            char src=source.charAt(i);
            char dest=target.charAt(i);
            if(src==dest) continue;
            long t=dist[src-'a'][dest-'a'];
            if(t==INF) return -1;
            res+=t;
        }
        return res;
    }
}