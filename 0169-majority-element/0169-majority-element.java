class Solution {
    public int majorityElement(int[] nums) {
        int count=0,res=0,n=nums.length;
        for(int i=0;i<n;i++){
            if(count==0) res=nums[i];
            count+=(res==nums[i])?1:-1; 
        }
        return res;
    }
}