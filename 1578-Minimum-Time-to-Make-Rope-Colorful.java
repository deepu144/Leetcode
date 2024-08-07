class Solution {
    public int minCost(String colors, int[] time) {
        char[] ch=colors.toCharArray();
        int l=0,r=0,n=time.length,max=-1,sum=0,res=0;
        while(r<n){
            sum+=time[r];
            max=Math.max(max,time[r]);
            if(r==n-1){
                if(r>l) res+=(sum-max);
                break;
            }
            if(ch[r]!=ch[r+1]){
                if(r>l) res+=(sum-max);
                r++;
                l=r;
                sum=0;
                max=-1;
            }else{
                r++;
            }
        }
        return res;
    }
}