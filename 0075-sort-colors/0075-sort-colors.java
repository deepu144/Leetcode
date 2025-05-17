class Solution {
    public void sortColors(int[] nums) {
        int[] arr=new int[3];
        int n=nums.length,i=0,j=0;
        for(int a : nums) arr[a]++;
        while(i<n){
            while(arr[j]>0){
                nums[i++]=j;
                arr[j]--;
            }
            j++;
        }
    }
}