class Solution {
    public boolean predictTheWinner(int[] nums) {
        int j=nums.length,tot=0;
        for(int n : nums) tot+=n;
        return helper(nums,0,j-1,tot,0,true);
    }
    public boolean helper(int[] nums,int i,int j,int tot,int sum,boolean isPlayerOneTurn){
        if(i>j) return sum>=(tot-sum);
        if(isPlayerOneTurn) return helper(nums,i+1,j,tot,sum+nums[i],false)||helper(nums,i,j-1,tot,sum+nums[j],false);
        else return helper(nums,i+1,j,tot,sum,true) && helper(nums,i,j-1,tot,sum,true);
    }
}