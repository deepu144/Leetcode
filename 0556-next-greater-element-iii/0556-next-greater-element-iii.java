class Solution {
    public int nextGreaterElement(int n) {
        Stack<Long> st=new Stack<>();
        long num=n;
        while(num>0){
            long r=num%10;
            if(!st.isEmpty() && st.peek()>r) break;
            st.push(r);
            num/=10;
        }
        if(num==0) return -1;
        PriorityQueue<Long> pq=new PriorityQueue<>(st);
        long r=num%10;
        num/=10;
        long ng=-1;
        List<Long> li=new ArrayList<>();
        while(!pq.isEmpty()){
            if(r<pq.peek()){
                ng=pq.poll();
                break;
            }
            li.add(pq.poll());
        }
        num=(num*10)+ng;
        pq.offer(r);
        pq.addAll(li);
        while(!pq.isEmpty()) num=(num*10)+pq.poll();
        if(num>Integer.MAX_VALUE) return -1;
        return (int)num;
    }
}