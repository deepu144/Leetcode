class Solution {
    public int minOperations(int n) {
        int count=0;
        while(n>0){
            int x=(int)(Math.log(n)/Math.log(2)),prev=(int)Math.pow(2,x),next=(int)Math.pow(2,x+1);
            int diff1=n-prev;
            int diff2=next-n;
            if(diff1>diff2) n=diff2;
            else n=diff1;
            count++;
        }
        return count;
    }
}