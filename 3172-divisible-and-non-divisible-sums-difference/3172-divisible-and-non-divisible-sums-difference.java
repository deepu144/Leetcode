class Solution {
    public int differenceOfSums(int n, int m) {
        int noOfterms = n / m;
        int divisibleSum = (noOfterms * ((2*m) + (noOfterms-1)*m)) / 2;
        int nonDivisibleSum = ((n * (n + 1)) / 2) - divisibleSum;
        return nonDivisibleSum-divisibleSum;
    }
}