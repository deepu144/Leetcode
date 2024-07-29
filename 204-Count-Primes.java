class Solution {
    public int countPrimes(int n){
        if(n<3) return 0;
        boolean[] prime = new boolean[n];
        for(int i=3;i<n;i+=2) prime[i]=true;
        int count=0;
        prime[2] = true; 
        for (int i=3; i*i<n; i+=2) if (prime[i]) for (int j = i*i; j<n; j+=2*i) prime[j] = false;
        for(int i=1;i<n;i++) if(prime[i]) count++;
        return count;
    }
}