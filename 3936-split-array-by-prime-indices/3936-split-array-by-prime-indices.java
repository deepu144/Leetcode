class Solution {
    static boolean[] prime;
    static boolean isCalculated=false;
    public long splitArray(int[] nums) {
        if(!isCalculated) init();
        long a=0L,b=0L;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(prime[i]) a+=nums[i];
            else b+=nums[i];
        }
        return Math.abs(a-b);
    }
    public void init(){
        isCalculated=true;
        int n=(int)(1e5+1);
        this.prime = new boolean[n];
        for(int i=3;i<n;i+=2) prime[i]=true;
        int count=0;
        prime[2] = true;
        for (int i=3; i*i<n; i+=2) if (prime[i]) for (int j = i*i; j<n; j+=2*i) prime[j] = false;
        for(int i=1;i<n;i++) if(prime[i]) count++;
    }
}