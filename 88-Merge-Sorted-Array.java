class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n==0) return;
        int j=0,i=0,t=m;
        while(j<n){
            if(nums1[i]==0 && i>=t) nums1[i]=nums2[j++];
            else if(nums1[i]>nums2[j]){
                shiftOne(nums1,n+m-2,i,nums2[j++]);
                t++;
            }
            i++;
        }
    }
    public void shiftOne(int[] arr,int n,int i,int num){
        while(n>=i){
            int t=arr[n];
            arr[n]=arr[n+1];
            arr[n+1]=t;
            n--;
        }
        arr[i]=num;
    }
}