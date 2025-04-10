class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int k) {
        int n=flowerbed.length,zeros=0;
        if(n==1 && flowerbed[0]==0 && k==1) return true;
        boolean isOneSeen=false;
        for(int i=0;i<n;i++){
            int val=flowerbed[i];
            if(val==0) zeros++;
            if(val==1 || i==n-1){
                if(i==n-1 && n==zeros) return (zeros+1)/2>=k;
                if(i==n-1 && val==0) isOneSeen=false;
                if(isOneSeen){
                    int t=(zeros-1)/2;
                    if(t>0) k-=t;
                }else{
                    int t=zeros/2;
                    if(t>0) k-=t;
                }
                if(k<=0) return true;
                zeros=0;
                isOneSeen=true;
            }
        }
        return k<=0;
    }
}