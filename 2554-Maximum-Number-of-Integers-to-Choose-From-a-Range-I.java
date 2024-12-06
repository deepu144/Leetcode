class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        boolean[] hash=new boolean[n+1];
        for(int i : banned) if(i<=n) hash[i]=true;
        int count=0,sum=0;
        for(int i=1;i<=n;i++){
            if(!hash[i]){
                if(sum+i<=maxSum){
                    sum+=i;
                    count++;
                }else break;
            }
        }
        return count;
    }
}