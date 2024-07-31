class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int max = -1,min=Integer.MAX_VALUE;
        for(int n : nums){
            max=Math.max(max,n);
            min=Math.min(min,n);
        }
        return Math.max(0,(max-k)-(min+k));
    }
}