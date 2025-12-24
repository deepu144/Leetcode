class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum = 0, cnt = 0, i = capacity.length - 1;
        for(int val : apple) sum += val;
        Arrays.sort(capacity);
        while(sum>0){
            sum -= capacity[i];
            i--;
            cnt++;
        }
        return cnt;
    }
}