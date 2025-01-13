class Solution {
    public int jump(int[] nums) {
        int n=nums.length,i=0,maxIndex=0,maxStep=0,jump=0;
        for(int j=0;j<n;j++) nums[j]+=j;
        maxStep=nums[i++];
        while(i<n){
            if(maxStep>=n-1) return jump+1;
            if(i<=maxStep){
                if(nums[i]>=nums[maxIndex]) maxIndex=i;
            }else if(i-1==maxStep){
                i=maxIndex;
                maxStep=nums[i];
                jump++;
                maxIndex=i;
            }
            i++;
        }
        return 0;
    }
}