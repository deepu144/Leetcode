class Solution {
    public int matrixSum(int[][] nums) {
        int r=nums.length,c=nums[0].length,res=0;
        for(int i=0;i<r;i++) Arrays.sort(nums[i]);
        for(int j=c-1;j>=0;j--){
            int max=-1;
            for(int i=0;i<r;i++) max=Math.max(max,nums[i][j]);
            res+=max;
        }
        return res;
    }
}