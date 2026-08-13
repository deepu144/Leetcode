class Solution {
    public int countPrimes(int n){
        if(n<3) return 0;
        boolean[] primes = new boolean[n];
        int cnt = 0;
        for(int i=3;i<n;i+=2) primes[i] = true;
        primes[2] = true;
        for(int i=3;i*i<n;i+=2) 
            if(primes[i]) 
                for(int j=i*i;j<n;j+=2*i)
                    primes[j] = false;
        for(int i=2;i<n;i++) 
            if(primes[i]) cnt++;
        return cnt;
    }
}