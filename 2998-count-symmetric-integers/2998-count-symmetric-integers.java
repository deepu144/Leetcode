class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count=0;
        for(int i=low;i<=high;i++){
            int noOfDigit=(int)(Math.floor(Math.log10(i))+1);
            if((noOfDigit&1)==1) continue;
            if(isSymmertric(i,noOfDigit/2)) count++;
        }
        return count;
    }
    public boolean isSymmertric(int val,int limit){
        int a=0,b=0,k=limit;
        while(val>0){
            if(k>0) a+=val%10;
            else b+=val%10;
            val/=10;
            k--;
        }
        return a==b;
    }
}