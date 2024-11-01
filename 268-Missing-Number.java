class Solution {
    public int missingNumber(int[] nums) {
        int expect=0,actual=0;
        for(int i=0;i<=nums.length;i++) expect^=i;
        for(int i : nums) actual^=i;
        return expect^actual;
    }
}