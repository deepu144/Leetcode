class Solution {
    public int numSubarrayProductLessThanK(int[] arr, int k) {
        if(k<=1) return 0;
        int res=0,pro=1,l=0,r=0,n=arr.length;
        while(r<n){
            pro*=arr[r];
            while(pro>=k) pro/=arr[l++];
            res+=r-l+1;
            r++;
        }
        return res;
    }
}