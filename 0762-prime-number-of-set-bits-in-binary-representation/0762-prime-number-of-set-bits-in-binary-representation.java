class Solution {
    private static final Set<Integer> primes = Set.of(2,3,5,7,11,13,17,19,23,29,31);
    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        for(int i = left; i <= right; i++) {
            if(primes.contains(Integer.bitCount(i))) count++;
        }
        return count;
    }
}