class Solution {
    public int maxFrequencyElements(int[] nums) {
        int n=nums.length,maxFrequency=0,cnt=0;
        int[] fre = new int[101];
        for(int val : nums){
            fre[val]++;
            maxFrequency = Math.max(maxFrequency,fre[val]);
        }
        for(int frequency : fre) if(frequency==maxFrequency) cnt++;
        return cnt*maxFrequency;
    }
}