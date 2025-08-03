class Solution {
    public int maxBalancedShipments(int[] weight) {
        int n=weight.length,i=1,cnt=0,max=weight[0];
        while(i<n){
            max=Math.max(max,weight[i]);
            if(max > weight[i]){
                cnt++;
                max=0;
            }
            i++;
        }
        return cnt;
    }
}