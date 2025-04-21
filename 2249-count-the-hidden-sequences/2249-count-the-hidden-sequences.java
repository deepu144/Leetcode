class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int n=differences.length;
        long min=0L,max=min,sum=min;
        for(int diff : differences){
            sum+=diff;
            min=Math.min(min,sum);
            max=Math.max(max,sum);
        }
        long lowerBound=(long)lower-min,upperBound=(long)upper-max;
        if(lowerBound>upperBound) return 0;
        return (int)(upperBound-lowerBound+1);
    }
}