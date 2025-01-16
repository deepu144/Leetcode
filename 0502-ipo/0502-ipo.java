class Solution {
    public int findMaximizedCapital(int k, int w, int[] profit, int[] capital) {
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->b.profit-a.profit);
        int n=capital.length;
        boolean check=false;
        Pair[] pair=new Pair[n];
        for(int i=0;i<n;i++){
            pair[i]=new Pair(capital[i],profit[i]);
            if(w>=capital[i]) check=true;
        }
        if(!check) return w;
        Arrays.sort(pair,(a,b)->a.capital-b.capital);
        int i=0;
        while(i<n && w>=pair[i].capital){
            pq.offer(pair[i]);
            i++;
        }
        while(!pq.isEmpty() && k-->0){
            Pair p=pq.poll();
            w+=p.profit;
            while(i<n && w>=pair[i].capital){
                pq.offer(pair[i]);
                i++;
            }
        }
        return w;
    }
}
class Pair{
    int capital;
    int profit;
    Pair(int c,int p){
        capital=c;
        profit=p;
    }
}