class Solution {
    public int[] shuffle(int[] nums, int n) {
        int len = n*2, m = 0;
        int[] arr = new int[len];
        for(int i=0;i<len;i++){
            if(i%2==0) arr[i] = nums[m++];
            else arr[i] = nums[n++];
        }
        return arr;
    }
}