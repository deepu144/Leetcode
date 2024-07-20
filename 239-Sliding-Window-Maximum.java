class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int[] res=new int[n-k+1];
        Deque<Integer> de = new LinkedList<>();
        int t=0,j=0;
        for(int i=0;i<n;i++){
            while(!de.isEmpty() && de.peekFirst()<i-k+1){
                de.pollFirst();
            }
            while(!de.isEmpty() && nums[de.peekLast()]<nums[i]){
                de.pollLast();
            }
            de.offer(i);
            if(i>=k-1){
                res[j++]=nums[de.peekFirst()];
            }
        }
        return res;
    }
}