class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n = happiness.length, temp = 0;
        Arrays.sort(happiness);
        long sum = 0L;
        while(k-->0){
            happiness[--n] -= temp++;
            if(happiness[n] > 0) sum += happiness[n];
        }
        return sum;
    }
}