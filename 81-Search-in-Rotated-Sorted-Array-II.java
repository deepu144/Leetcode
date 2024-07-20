class Solution {
    public boolean search(int[] arr, int target) {
        int pivot = findPivot(arr , 0 , arr.length-1);
        if(pivot == -1) {
            return binarySearch(arr, 0, arr.length - 1, target);
        }
        else if(arr[pivot]==target){
            return true;
        } 
        else{
            if(target >= arr[0]){
                return binarySearch(arr, 0, pivot-1, target);
            }
            return binarySearch(arr, pivot + 1, arr.length - 1, target);
        }
    }
    public int findPivot(int[] arr, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;

        if (mid < end && arr[mid] > arr[mid + 1]) {
            return mid;
        }
        if (mid > start && arr[mid] < arr[mid - 1]) {
            return mid - 1;
        }
        if (arr[start] == arr[mid] && arr[mid] == arr[end]) {
            int pivot = findPivot(arr, start, mid - 1);
            if (pivot != -1) {
                return pivot;
            }
            return findPivot(arr, mid + 1, end);
        }
        if (arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
            return findPivot(arr, mid + 1, end);
        } else {
            return findPivot(arr, start, mid - 1);
        }
    }


    public boolean binarySearch(int[] arr, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < target) {
                start = mid + 1;
            } else if (arr[mid] > target) {
                end = end - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
