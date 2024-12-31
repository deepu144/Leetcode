class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        return minCost(days,costs,days.length,0,new Integer[366]);
    }
    public int minCost(int[] days,int[] costs,int n,int i,Integer[] dp){
        if(i>=n) return 0;
        if(dp[i]!=null) return dp[i];
        int one=costs[0]+minCost(days,costs,n,i+1,dp);
        int seven=costs[1]+minCost(days,costs,n,getCeil(i,days[i]+6,days,n),dp);
        int thirty=costs[2]+minCost(days,costs,n,getCeil(i,days[i]+29,days,n),dp);
        return dp[i]=Math.min(one,Math.min(seven,thirty));
    }
    public int getCeil(int start,int x,int[] arr,int n){
        int end=n-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(arr[mid]>x){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return start;
    }
}