class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length,i=0;
        while(i<n){
            if(gas[i]-cost[i]>=0){
                int currGas=gas[i]-cost[i],j=(i+1)%n;
                while(currGas>=0){
                    if(i==j) return i;
                    currGas+=(gas[j]-cost[j]);
                    j=(j+1)%n;
                }
                if(j<=i) return -1;
                i=j;
            }else i++;
        }
        return -1;
    }
}