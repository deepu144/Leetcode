class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> left=new PriorityQueue<>((a,b)->a-b);
        PriorityQueue<Integer> right=new PriorityQueue<>((a,b)->a-b);
        int n=costs.length,l=candidates,r=n-candidates-1;
        long res=0;
        if(l>r || k==n){
            for(int i=0;i<n;i++) left.offer(costs[i]);
            while(k!=0){
                res+=left.poll();
                k--;
            }   
            return res;
        }
        for(int i=0;i<candidates;i++){
            left.offer(costs[i]);
            right.offer(costs[n-i-1]);
        } 
        while(k!=0){
            if(l>r){
                if(!left.isEmpty() && !right.isEmpty()){
                    if(left.peek()==right.peek()) res+=left.poll();
                    else if(left.peek()>right.peek()) res+=right.poll();
                    else res+=left.poll();
                }else{
                    if(!left.isEmpty() && right.isEmpty()) res+=left.poll();
                    else if(left.isEmpty() && !right.isEmpty()) res+=right.poll();
                }
            }else{
                if(left.peek()==right.peek()){
                    res+=left.poll();
                    left.offer(costs[l++]);
                }else if(left.peek()>right.peek()){
                    res+=right.poll();
                    right.offer(costs[r--]);
                }else{
                    res+=left.poll();
                    left.offer(costs[l++]);
                }
            }
            k--;
        }
        return res;
    }
}