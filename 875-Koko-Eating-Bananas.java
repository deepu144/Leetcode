class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start=1,end=Integer.MAX_VALUE;
        while(start<=end){
            int mid=start+(end-start)/2;
            int t = satisfy(piles,h,mid);
            if(t>h) start=mid+1;
            else end=mid-1;
        }
        return start;
    }
    public int satisfy(int[] arr,int h,int ans){
        int t=0;
        int n=arr.length;
        for(int i=0;i<n;i++) t+=Math.ceil((double)(arr[i])/(double)(ans));
        return t;
    }
}