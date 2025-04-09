class Solution {
    public int minOperations(int[] nums, int k) {
        int n=nums.length,cnt=0;
        int[] fre=new int[101];
        for(int val : nums){
            if(val<k) return -1;
            fre[val]++;
            if(fre[val]==1 && val>k) cnt++;
        }
        return cnt;
    }
}