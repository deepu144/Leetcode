class Solution {
    public int trap(int[] arr) {
        int n = arr.length;
        int a=0,b=n-1,leftmax=0,rightmax=0;
        int res=0;
        while(a<=b){
            if(arr[a]<=arr[b]){
                leftmax=Math.max(leftmax,arr[a]);
                if(arr[a]<leftmax) res+=(leftmax-arr[a]);
                a++;
            }else{
                rightmax=Math.max(rightmax,arr[b]);
                if(arr[b]<rightmax) res+=(rightmax-arr[b]);
                b--;
            }
        }
        return res;
    }
}