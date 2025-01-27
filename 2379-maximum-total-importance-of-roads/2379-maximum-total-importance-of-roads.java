class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] degree=new int[n];
        for(int[] a : roads){
            degree[a[0]]++;
            degree[a[1]]++;
        }
        Integer[] arr=new Integer[n];
        for(int i=0;i<n;i++) arr[i]=i;
        Arrays.sort(arr,(a,b)->degree[a]-degree[b]);
        int[] hash=new int[n];
        for(int i=0;i<n;i++) hash[arr[i]]=i+1;
        long res=0;
        for(int[] a : roads){
            res+=hash[a[0]];
            res+=hash[a[1]];
        }
        return res;
    }
}