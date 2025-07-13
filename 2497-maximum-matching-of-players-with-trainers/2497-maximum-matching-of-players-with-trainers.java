class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int count=0,n=trainers.length,m=players.length,j=0,i=0;
        while(i<m){
            if(j<n && players[i]<=trainers[j]){
                count++;
                i++;
                j++;
            }else if(j<n && players[i]>trainers[j]) j++;
            if(j>=n) break;
        }
        return count;
    }
}