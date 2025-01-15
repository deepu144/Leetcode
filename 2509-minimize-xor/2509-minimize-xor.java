class Solution {
    public int minimizeXor(int num1, int num2) {
        int oneCount=Integer.bitCount(num2),ans=0;
        int highestBit=Integer.highestOneBit(num1);
        while(oneCount>0 && highestBit>0){
            if((num1 & highestBit)!=0){
                int pos=(int)(Math.log(highestBit)/Math.log(2));
                ans|=(1<<pos);
                oneCount--;
            }
            highestBit>>=1;
        }
        for(int i=0;oneCount>0;i++){
            if((ans & (1<<i))==0){
                ans|=(1<<i);
                oneCount--;
            }
        }
        return ans;
    }
}