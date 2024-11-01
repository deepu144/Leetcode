class Solution {
    public int hammingWeight(int n) {
        int bits=0;
        while(n!=0){
            n&=n-1;
            bits++;
        }
        return bits;
    }
}