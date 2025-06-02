class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int st=0,end=(int)(1e7),n=dist.length,ans=-1;
        while(st<=end){
            int mid = st+(end-st)/2;
            if(isPossible(dist,hour,mid,n)){
                ans=mid;
                end=mid-1;
            }
            else st=mid+1;
        }
        return ans;
    }
    public boolean isPossible(int[] dist,double hour,int speed,int n){
        for(int i=0;i<n-1;i++){
            double t = Math.ceil( (dist[i]*1.0)/speed );
            hour-=t;
            if(hour<0) return false;
        }
        hour -= (dist[n-1]*1.0)/speed;
        return hour+1e-9>=0.0;
    }
}