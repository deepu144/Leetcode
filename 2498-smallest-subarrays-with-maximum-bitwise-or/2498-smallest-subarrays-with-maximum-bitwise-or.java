class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n=nums.length;
        int[][] bit = new int[n][32];
        int[][] mat = new int[32][n];
        int[] res=new int[n];
        res[n-1]=1;
        for(int j=0;j<n;j++){
            for(int i=0;i<32;i++){
                bit[j][31-i] = ((1<<i) & nums[j]) !=0 ? 1 : 0;
            }
        }
        for(int i=31;i>=0;i--){
            int prev=-1;
            for(int j=n-1;j>=0;j--){
                if(bit[j][i]==1) prev=j;
                mat[i][j]=prev;
            }
        }
        for(int i=0;i<n-1;i++){
            int max=-1;
            for(int j=0;j<32;j++) max=Math.max(mat[j][i],max);
            if(max<0) max=i;
            res[i]=max-i+1;
        }
        return res;
    }
}