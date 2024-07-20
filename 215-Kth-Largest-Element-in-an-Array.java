class Solution {
    public int findKthLargest(int[] nums, int k) {
        int[] heap = new int[20001];
        for(int i : nums){
            heap[i+10000]++;
        }
        int s=0;
        for(int i=20000;i>=0;i--){
            s+=heap[i];
            if(s>=k){
                return i-10000;
            }
        }
        return -1;
    }
}