class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        int n=nums.length;
        long res=0;
        for(int i=0;i<n;i++){
            int l=binarySearchLower(nums,nums[i],i+1,n-1,lower);
            if(l==-1) continue;
            int h=binarySearchUpper(nums,nums[i],l,n-1,upper);
            if(h==-1) continue;
            res+=(h-l+1);
        }
        return res;
    }
    public int binarySearchLower(int[] arr,int num,int start,int end,int lower){
        int ans=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(num+arr[mid]>=lower){
                ans=mid;
                end=mid-1;
            }else start=mid+1;
        }
        return ans;
    }
    public int binarySearchUpper(int[] arr,int num,int start,int end,int upper){
        int ans=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(num+arr[mid]<=upper){
                ans=mid;
                start=mid+1;
            }else end=mid-1;
        }
        return ans;
    }
}