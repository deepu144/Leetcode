class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k){
        long res=-1,sum=0;
        Pair[] pair=new Pair[n];
        for(int i=0;i<n;i++) pair[i]=new Pair(speed[i],efficiency[i]);
        Arrays.sort(pair,(a,b)->b.e-a.e);
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(Pair p : pair){
            sum+=p.s;
            pq.offer(p.s);
            if(pq.size()>k) sum-=pq.poll();
            res=Math.max(res,sum*p.e);
        }
        return (int)(res%((int)1e9+7));
    }
}
class Pair{
    int s,e;
    public Pair(int s,int e){
        this.s=s;
        this.e=e;
    }
}