class Solution {
    public boolean canReach(int[] arr, int start) {
        int n=arr.length;
        return helper(arr,n,start,new boolean[n]);
    }
    public boolean helper(int[] arr,int n,int i,boolean[] visited){
        if(i<0 || i>=n || visited[i]) return false;
        if(arr[i]==0) return true;
        visited[i]=true;
        return helper(arr,n,i+arr[i],visited) || helper(arr,n,i-arr[i],visited);
    }
}