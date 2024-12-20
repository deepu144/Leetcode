class Solution {
    public int eraseOverlapIntervals(int[][] arr) {
        Arrays.sort(arr,(a,b)->a[1]-b[1]);
        int count=0,n=arr.length,end=arr[0][1];
        for(int i=1;i<n;i++){
            if(arr[i][0]<end) count++;
            else end=arr[i][1];
        }
        return count;
    }
}