class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int n = tickets.length, cnt = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=0;i<n;i++) deque.offer(i);
        while(tickets[k] != 0){
            int idx = deque.poll();
            tickets[idx]--;
            if(tickets[idx] > 0) deque.offer(idx);
            cnt++;
        }
        return cnt;
    }
}