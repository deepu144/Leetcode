class Solution {
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            if(a[0]==b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });
        int n=apples.length,count=0,end=n-1;
        for(int i=0;i<n;i++){
            while(!pq.isEmpty() && pq.peek()[0]<=i) pq.poll();
            if(apples[i]!=0 && days[i]!=0) pq.offer(new int[]{i+days[i],apples[i]});
            if(!pq.isEmpty()){
                count++;
                pq.peek()[1]--;
                if(pq.peek()[1]==0) pq.poll();
            }
        }
        System.out.println(count);
        int extraApples=0;
        while(!pq.isEmpty()){
            int[] p=pq.poll();
            if(p[0]-end<=0) continue;
            int remainDays=p[0]-end-1;
            int extra=Math.min(remainDays,p[1]);
            extraApples+=extra;
            end+=extra;
        }
        return count+extraApples;
    }
}