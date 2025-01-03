class Solution {
    public long numberOfSubsequences(int[] nums) {
        long res=0;
        int n=nums.length;
        Map<Double,Integer> map=new HashMap<>();
        for(int r=4;r<n-2;r++){
            int q=r-2;
            for(int p=0;p<q-1;p++){
                double ratio =1.0*nums[p]/nums[q];
                map.put(ratio,map.getOrDefault(ratio,0)+1);
            }
            for(int s=r+2;s<n;s++){
                double ratio=1.0*nums[s]/nums[r];
                res+=map.getOrDefault(ratio,0);
            }
        }
        return res;
    }
}