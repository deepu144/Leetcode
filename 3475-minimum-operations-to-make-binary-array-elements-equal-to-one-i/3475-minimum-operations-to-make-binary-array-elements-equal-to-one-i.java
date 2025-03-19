class Solution {
    public int minOperations(int[] nums) {
        int n=nums.length,zeros=0,count=0,i=0;
        for(int val : nums) if(val==0) zeros++;
        while(i<n-2 && zeros!=0){
            if(nums[i]==1){
                i++;
                continue;
            }
            if(nums[i+2]==0 || nums[i+1]==0 || nums[i]==0){
                nums[i+2]=(nums[i+2]==0?1:0);
                nums[i+1]=(nums[i+1]==0?1:0);
                nums[i]=(nums[i]==0?1:0);
                zeros+=(nums[i+2]==1?-1:1);
                zeros+=(nums[i+1]==1?-1:1);
                zeros+=(nums[i]==1?-1:1);
                count++;
            }
            i++;
        }
        return (zeros==0)?count:-1;
    }
}