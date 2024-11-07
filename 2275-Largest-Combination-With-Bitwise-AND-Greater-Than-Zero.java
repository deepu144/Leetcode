class Solution {
    public int largestCombination(int[] arr) {
        int n=arr.length,max=-1;
        for(int i=0;i<=31;i++){
            int count=0;
            for(int j=0;j<n;j++) if(((1<<i)&arr[j])>=1) count++;
            max=Math.max(max,count);
        }
        return max;
    }
}