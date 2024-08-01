class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length,n=matrix[0].length;
        int end=m*n-1,start=0;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(target==matrix[mid/n][mid%n]) return true;
            else if(target>matrix[mid/n][mid%n]) start=mid+1;
            else end=mid-1;
        }
        return false;
    }
}