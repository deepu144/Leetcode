class Solution {
    public int maximumPopulation(int[][] logs) {
        int min=logs[0][0],max=logs[0][1];
        for(int[] a : logs){
            min=Math.min(a[0],min);
            max=Math.max(a[1],max);
        }
        int n=max-min+1;
        int[] sweep=new int[n];
        for(int[] a : logs){
            sweep[a[0]-min]++;
            sweep[a[1]-min]--;
        }
        for(int i=1;i<n;i++) sweep[i]+=sweep[i-1];
        int res=0;
        max=-1;
        for(int i=0;i<n;i++){
            if(max<sweep[i]){
                max=sweep[i];
                res=i;
            }
        }
        return res+min;
    }
}