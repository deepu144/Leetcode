class Solution {
    public int edgeScore(int[] edges) {
        int n=edges.length,index=-1;
        long max=0;
        long[] degree=new long[n];
        for(int i=0;i<n;i++) degree[edges[i]]+=i;
        for(int i=0;i<n;i++){
            if(degree[i]>max){
                max=degree[i];
                index=i;
            }
        }
        return index;
    }
}