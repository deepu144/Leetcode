class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n=nums.length;
        if(n<=2) return n;
        return 1<<(int)(Math.floor(Math.log(n)/Math.log(2)))+1;
    }
}