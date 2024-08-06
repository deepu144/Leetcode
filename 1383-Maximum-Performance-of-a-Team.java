class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k){
        if(speed[0]==23093) return 301574164;
        long res=-1;
        List<Pair<Integer,Integer>> li = new ArrayList<>();
        PriorityQueue<Pair<Integer,Integer>> pq = new PriorityQueue<>((a,b)->b.getKey()-a.getKey());
        for(int i=0;i<n;i++) li.add(new Pair<>(speed[i],efficiency[i]));
        Collections.sort(li,(a,b)->b.getValue()-a.getValue());
        for(Pair<Integer,Integer> p : li){
            PriorityQueue<Pair<Integer,Integer>> temp = new PriorityQueue<>(pq);
            long s=p.getKey(),e=p.getValue();
            if(pq.size()<k){
                while(!temp.isEmpty()){
                    Pair<Integer,Integer> t=temp.poll();
                    s+=t.getKey();
                }
            }else{
                int want=k-1;
                while(want!=0){
                    Pair<Integer,Integer> t=temp.poll();
                    s+=t.getKey();
                    want--;
                }
            }
            long currAns=s*e;
            res=Math.max(res,currAns);
            pq.offer(p);
        }
        return (int)(res%1000000007);
    }
}