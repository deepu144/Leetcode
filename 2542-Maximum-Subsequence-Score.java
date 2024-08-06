class Solution {
    public long maxScore(int[] speed, int[] efficiency, int k) {
        long res=-1,sum=0;
        int n=speed.length;
        Pair[] pair=new Pair[n];
        for(int i=0;i<n;i++) pair[i]=new Pair(speed[i],efficiency[i]);
        Arrays.sort(pair,(a,b)->b.e-a.e);
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(Pair p : pair){
            sum+=p.s;
            pq.offer(p.s);
            if(pq.size()>k) sum-=pq.poll();
            if(pq.size()==k) res=Math.max(res,sum*p.e);
        }
        return res;
    }
}
class Pair{
    int s,e;
    public Pair(int s,int e){
        this.s=s;
        this.e=e;
    }
}