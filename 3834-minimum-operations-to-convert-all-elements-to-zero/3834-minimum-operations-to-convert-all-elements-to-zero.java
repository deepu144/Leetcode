class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length,cnt=0;
        int[] nextMin = new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]) nextMin[st.pop()]=nums[i];
            st.push(i);
        }
        for(int i=0;i<n;i++) if(nums[i]>nextMin[i]) cnt++;
        return cnt;
    }
}