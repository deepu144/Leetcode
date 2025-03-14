class Solution {
    public int maximumCandies(int[] candies, long k) {
        int n=candies.length;
        long st=0L,end=0L,tot=0L;
        for(int i : candies) tot+=i;
        end=tot; 
        if(end<k) return 0;
        if(end==k) return 1;
        while(st<=end){
            long mid=st+(end-st)/2;
            if(canAllocateCandies(candies,n,mid,k,tot)) st=mid+1;
            else end=mid-1;
        }
        return (int)end;
    }
    public boolean canAllocateCandies(int[] candies,int n,long ans,long k,long tot){
        if(ans==0) return tot>=k;
        long children=0L;
        for(int i=0;i<n;i++) children+=(candies[i]/ans);
        return children>=k;
    }
}