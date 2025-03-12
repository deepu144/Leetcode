class Solution {
    public int maximumCount(int[] nums) {
        int pos=0,neg=0;
        for(int val : nums){
            if(val<0) neg++;
            else if(val>0) pos++;
        }
        return Math.max(neg,pos);
    }
}