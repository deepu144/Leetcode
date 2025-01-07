class Solution {
    public boolean makesquare(int[] matchsticks) {
        int n=matchsticks.length,tot=0;
        for(int i : matchsticks) tot+=i;
        if(tot%4!=0) return false;
        Arrays.sort(matchsticks);
        return makeSquare(matchsticks,tot/4,0,4,n,new int[5],new boolean[n]);
    }
    public boolean makeSquare(int[] arr,int target,int start,int k,int n,int[] side,boolean[] used){
        if(k==0) return true;
        if(side[k]==target) return makeSquare(arr,target,0,k-1,n,side,used);
        for(int j=start;j<n;j++){
            if(used[j] || side[k]+arr[j]>target) continue;
            side[k]+=arr[j];
            used[j]=true;
            if(makeSquare(arr,target,j+1,k,n,side,used)) return true;
            used[j]=false;
            side[k]-=arr[j];
            while(j+1<n && arr[j]==arr[j+1]) j++;
        }
        return false;
    }
}