class Solution {
    public int[] rearrangeBarcodes(int[] arr){
        int n=arr.length,j=0;
        int[] res=new int[n];
        int[] hash=new int[10001];
        for(int i : arr) hash[i]++;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->b.fre-a.fre);
        for(int i=0;i<10001;i++) if(hash[i]!=0) pq.offer(new Pair(i,hash[i]));
        while(!pq.isEmpty()){
            ArrayList<Pair> li=new ArrayList<>();
            if(j==0){
                Pair p = pq.poll();
                res[j++]=p.val;
                p.fre--;
                li.add(p);
            }else{
                Pair p=null;
                while(!pq.isEmpty()&&((p=pq.poll()).val==res[j-1])){
                    li.add(p);
                }
                res[j++]=p.val;
                p.fre--;
                li.add(p);
            }
            for(Pair p : li) if(p.fre!=0) pq.offer(p);
        }
        return res;
    }
}
class Pair{
    int val;
    int fre;
    Pair(int val,int fre){
        this.val=val;
        this.fre=fre;
    }
}