class Solution {
    public int minTime(String s, int[] order, int k) {
        int n=s.length(),st=0,end=n-1,ans=-1;
        while(st<=end){
            int mid = (st+end)/2;
            if(isValid(order,n,mid,k)){
                ans=mid;
                end=mid-1;
            }else st=mid+1;
        }
        return ans;
    }
    public boolean isValid(int[] order,int n,int t,int k){
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<=t;i++) pq.offer(order[i]);
        int prev=-1;
        long cnt=0L;
        while(!pq.isEmpty()){
            int curr = pq.poll(),before=-1,after=n-1-curr;
            if(prev==-1) before = curr;
            else before = curr-prev-1;
            cnt+=(before+after+(1L*before*after)+1L);
            prev=curr;
        }
        return cnt>=k;
    }
}