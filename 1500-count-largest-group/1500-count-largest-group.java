class Solution {
    public int countLargestGroup(int n) {
        int[] hash=new int[37];
        int max=0,cnt=0;
        for(int i=1;i<=n;i++){
            int t=digitSum(i);
            hash[t]++;
            max=Math.max(max,hash[t]);
        }
        for(int i=1;i<37;i++) if(hash[i]==max) cnt++;
        return cnt;
    }
    public int digitSum(int n){
        int sum=0;
        while(n>0){
            sum += n%10;
            n/=10;
        }
        return sum;
    }
}