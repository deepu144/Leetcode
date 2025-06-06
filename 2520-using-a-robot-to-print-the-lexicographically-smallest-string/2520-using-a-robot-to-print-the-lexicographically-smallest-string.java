class Solution {
    public String robotWithString(String s) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
            if(s.charAt(a)==s.charAt(b)) return a-b;
            return s.charAt(a)-s.charAt(b);
        });
        StringBuilder sb=new StringBuilder();
        int n=s.length(),pre=0;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++) pq.offer(i);
        while(!pq.isEmpty()){
            int curr=pq.poll();
            if(curr<pre) continue;
            for(int i=pre;i<=curr;i++) st.push(i);
            while(!pq.isEmpty() && pq.peek() < curr) pq.poll();
            while(!pq.isEmpty() && !st.isEmpty() && s.charAt(pq.peek()) >= s.charAt(st.peek())) sb.append(s.charAt(st.pop()));
            pre=curr+1;
        }
        while(!st.isEmpty()) sb.append(s.charAt(st.pop()));
        return sb.toString();
    }
}