class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] outDegree=new int[n];
        boolean[][] adj=new boolean[n][n];
        for(int[] a : roads){
            adj[a[0]][a[1]]=adj[a[1]][a[0]]=true;
            outDegree[a[0]]++;
            outDegree[a[1]]++;
        }   
        int max=-1;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++) max=Math.max(max,outDegree[i]+outDegree[j]-(adj[i][j]?1:0));
        }
        return max;
    }
}