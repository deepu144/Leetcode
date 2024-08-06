class Solution {
    public int minDifference(int[] arr) {
        Arrays.sort(arr);
        int n=arr.length;
        if(n<=4) return 0;
        return Math.min(Math.min(arr[n-1]-arr[3],arr[n-4]-arr[0]),Math.min(arr[n-2]-arr[2],arr[n-3]-arr[1]));
    }
}