class Solution {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length-1;
        int max=0;
        while(start<end){
            if(height[start]<height[end]){
                int sum = (height[start])*(end-start);
                if(sum>max){
                    max = sum;
                }
                start++;
                continue;
            }
            else if(height[start]>=height[end]){
                int sum = (height[end])*(end-start);
                if(sum>max){
                    max = sum;
                }
                end--;
            }
        }
        return max;
    }
}