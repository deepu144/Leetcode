class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = neededTime.length, i=0, max=0, tot=0, res=0;
        char prev = '.';
        while(i<n){
            char ch = colors.charAt(i);
            if(ch==prev){
                max = Math.max(max, neededTime[i]);
                tot += neededTime[i];
            }else{
                res += (tot - max);
                prev = ch;
                tot = neededTime[i];
                max = tot;
            }
            i++;
        }
        res += (tot - max);
        return res;
    }
}