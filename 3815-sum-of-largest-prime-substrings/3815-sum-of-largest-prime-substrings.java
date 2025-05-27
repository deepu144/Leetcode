class Solution {
    public long sumOfLargestPrimes(String s) {
        int n = s.length();
        PriorityQueue<Long> pq=new PriorityQueue<>();
        Set<Long> set=new HashSet<>();
        long res=0L;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<=n;j++){
                if(j-1>=0 && j-i != 1 && (s.charAt(j-1)-'0')%2==0) continue;
                long val = Long.parseLong(s.substring(i,j));
                if(!set.add(val)) continue;
                if(isPrime(val)){
                    pq.offer(val);
                    if(pq.size() > 3) pq.poll();
                }
            }
        }
        while(!pq.isEmpty()) res += pq.poll();
        return res;
    }
    public boolean isPrime(long val){
        if(val == 1) return false;
        if(val == 2) return true;
        long sqrt = (long)Math.sqrt(val);
        for(long i=2 ; i<=sqrt ; i++) if(val % i == 0) return false;
        return true;
    }
}