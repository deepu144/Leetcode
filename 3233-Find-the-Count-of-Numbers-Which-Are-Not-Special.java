class Solution {
    public int nonSpecialCount(int l, int r) {
        int count=r-l+1;
        for(int i=1;i*i<=r;i++){
            if(i%2==0 && i!=2) continue;
            boolean flag=false;
            for(int j=2;j<=(int)Math.sqrt(i);j++){
                if(i%j==0){
                    flag=true;
                    break;
                }
            }
            if(!flag){
                if(i*i>=l && i*i<=r && i!=1) count--;
            }
        }
        return count;
    }
}