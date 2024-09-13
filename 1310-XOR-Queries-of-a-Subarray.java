class Solution {
    public int[] xorQueries(int[] arr, int[][] q) {
        int n = arr.length;
        int[] pre=new int[n];
        int xor=0;
        for(int i=0;i<n;i++){
            xor^=arr[i];
            pre[i]=xor;
        }
        int[] res = new int[q.length];
        int j=0;
        for(int[] a : q){
            if(a[0]>0) res[j++]=pre[a[0]-1]^pre[a[1]];
            else res[j++]=pre[a[1]];
        }
        return res;
    }
}