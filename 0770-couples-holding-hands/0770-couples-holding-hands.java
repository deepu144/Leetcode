class Solution {
    public int minSwapsCouples(int[] row) {
        int n=row.length,swap=0;
        int[] map=new int[n];
        for(int i=0;i<n;i++) map[row[i]]=i;
        for(int i=0;i<n;i+=2){
            if(((row[i]&1)==1 && row[i+1]==row[i]-1) || ((row[i]&1)==0) && row[i]+1==row[i+1]) continue;
            int actualPair=(row[i]&1)==0?row[i]+1:row[i]-1;
            row[map[actualPair]]=row[i+1];
            map[row[i+1]]=map[actualPair];
            row[i+1]=actualPair;
            swap++;
        }
        return swap;
    }
}