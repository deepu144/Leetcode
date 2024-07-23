class Solution{
    public boolean canCross(int[] stones){
        if(stones[1]!=1) return false;
        int n = stones.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(stones[i],i);
        }
        boolean dp[][]=new boolean[n+1][1000];
        return check(1,stones,map,1,n,dp);
    }
    public boolean check(int i,int[] arr,Map<Integer,Integer> hash,int k,int n,boolean dp[][]){
        if(i==n-1){
            return true;
        }
        int pos = arr[i];
        for(int step = k-1;step<=k+1;step++){
            if(step>0){
                int nextPos=pos+step;
                Integer index=hash.get(nextPos);
                if(index!=null && !dp[index][step]){
                    dp[index][step]=true;
                    if(check(index,arr,hash,step,n,dp)) return true;
                }
            }
        }
        return false;
    }
}