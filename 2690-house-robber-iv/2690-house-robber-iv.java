class Solution {
    public int minCapability(int[] nums, int k) {
        int n=nums.length,st=0,end=n-1;    
        int[] arr=Arrays.copyOf(nums,n);
        Arrays.sort(arr);
        while(st<=end){
            int mid=(st+end)/2;
            if(canSteal(arr[mid],nums,k,n)) end=mid-1;
            else st=mid+1;
        }
        return arr[st];
    }
    public boolean canSteal(int val,int[] nums,int k,int n){
        int a=0,i=0;
        while(i<n){
            if(nums[i]<=val){
                a++;
                i+=2;
            }else i++;
            if(k<=a) return true;
        }
        return k<=a;
    }
}