class Solution {
    public int maxCoins(int[] piles) {
        int res=0,n=piles.length,coins=n/3,i=n-2;
        Arrays.sort(piles);
        while(coins!=0){
            res+=piles[i];
            i-=2;
            coins--;
        }
        return res;
    }
}