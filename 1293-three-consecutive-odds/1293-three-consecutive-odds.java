class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int n=arr.length;
        if(n<3) return false;
        for(int i=2;i<n;i++){
            if(isOdd(arr[i-2]) && isOdd(arr[i-1]) && isOdd(arr[i])) return true;
        }
        return false;
    }
    public boolean isOdd(int n){
        return (n&1)==1;
    }
}