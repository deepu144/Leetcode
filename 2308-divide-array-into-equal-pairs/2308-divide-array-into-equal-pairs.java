class Solution {
    public boolean divideArray(int[] nums){
        int[] hash=new int[500+1];
        for(int val : nums) hash[val]++;
        for(int i=1;i<=500;i++) if((hash[i]&1)==1) return false;
        return true;
    }
}