class Solution {
    public void sortColors(int[] nums) {
        nums = quickSort(nums,0,nums.length-1);
    }

    public static int[] quickSort(int[] arr , int low , int high){

        if(low<high){
            int pivot = low;
            int i = low;
            int j = high;

            while(i<j){
                while(arr[i]<=arr[pivot] && i<high){
                    i++;
                }
                while(arr[j]>arr[pivot] && j>low){
                    j--;
                }
                if(i<j){
                    int t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
            }
            int tp = arr[pivot];
            arr[pivot] = arr[j];
            arr[j] = tp;
            quickSort(arr,low,j-1);
            quickSort(arr,j+1,high);
            return arr;
        }
        return arr;
    }
}