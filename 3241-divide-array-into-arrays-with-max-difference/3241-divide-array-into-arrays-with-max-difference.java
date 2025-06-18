class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n=nums.length,m=n/3,i=0,j=0,min=-1;
        Arrays.sort(nums);
        int[][] res=new int[m][3];
        for(int val : nums){
            if(min==-1) min=val;
            res[i][j++]=val;
            if(j==3){
                if(val-min > k) return new int[][]{};
                j=0;
                i++;
                min=-1;
            }
        }
        return res;
    }
}