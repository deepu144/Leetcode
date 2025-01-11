class Solution {
    public long findMaximumScore(List<Integer> nums) {
        long max=0;
        int n=nums.size(),pre=nums.getFirst(),preIndex=0;
        for(int i=1;i<n;i++){
            if(nums.get(i)>pre|| i==n-1){
                max+=(long)(i-preIndex)*nums.get(preIndex);
                pre=nums.get(i);
                preIndex=i;
            }
        }
        return max;
    }
}