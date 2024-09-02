class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long sum=0,n=chalk.length;
        for(int i : chalk) sum+=i;
        int rem=(int)(k%sum);
        for(int i=0;i<n;i++){
            if(rem-chalk[i]<0) return i;
            rem-=chalk[i];
        }
        return 0;
    }
}