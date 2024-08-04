class Solution {
    public int winningPlayerCount(int n, int[][] pick) {
        int[][] hash=new int[n+1][11];
        int res=0;
        for(int[] arr : pick){
            hash[arr[0]][arr[1]]++;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<11;j++){
                if(hash[i][j]>i){
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}