class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n=nums.length;
        int[] hash=new int[n+1];
        for(int[] query : queries){
            hash[query[0]]++;
            hash[query[1]+1]--;
        }
        for(int i=1;i<=n;i++){
            hash[i]+=hash[i-1];
            if(nums[i-1]>hash[i-1]) return false;
        }
        return true;
    }
}