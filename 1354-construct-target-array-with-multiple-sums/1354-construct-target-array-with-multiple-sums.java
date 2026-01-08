class Solution {
    public boolean isPossible(int[] target) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        int n = target.length;
        if(n == 2 && (target[0]==1 || target[1]==1)) return true;
        long tot = 0L;
        for(int val : target){
            pq.offer(val);
            tot += val;
        }
        while(!pq.isEmpty()){
            int curr = pq.poll();
            if(curr < 2) continue;
            long compliment = tot - curr;
            if(compliment == 0 || (compliment != 1 && compliment >= curr)) return false;
            long actual = curr % compliment;
            if(n !=2 && actual == 0) return false;
            tot = actual+compliment;
            pq.offer((int)actual);
        }
        return true;
    }
}