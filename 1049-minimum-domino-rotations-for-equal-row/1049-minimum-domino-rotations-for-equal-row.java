class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n=tops.length;
        int min1=minRotation(tops,bottoms,n,tops[0]);
        if(min1==-1) return minRotation(tops,bottoms,n,bottoms[0]);
        int min2 = minRotation(tops,bottoms,n,bottoms[0]);
        if(min2==-1) return min1;
        return Math.min(min1,min2);
    }
    public int minRotation(int[] top,int[] bottoms,int n,int val){
        int cnt=0,same=0;
        for(int i=0;i<n;i++){
            if(top[i]!=val){
                if(bottoms[i]!=val) return -1;
                cnt++;
            }else if(bottoms[i]==val) same++;
        }
        return Math.min(cnt,n-cnt-same);
    }
}