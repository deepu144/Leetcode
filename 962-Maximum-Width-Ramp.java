class Solution {
    public int maxWidthRamp(int[] nums) {
        int ans=-1,n=nums.length;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            if(st.isEmpty() || nums[st.peek()]>nums[i]) st.push(i);
        }
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[i]>=nums[st.peek()]){
                ans=Math.max(ans,i-st.pop());
            }
        }
        return ans;
    }
}