class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n=blocks.length(),count=n+1,black=0;
        for(int i=0;i<k;i++) if(blocks.charAt(i)=='B') black++;
        count=Math.min(count,k-black);
        for(int i=k;i<n;i++){
            if(blocks.charAt(i)=='B') black++;
            if(blocks.charAt(i-k)=='B') black--;
            count=Math.min(count,k-black);
        }
        return count;
    }
}