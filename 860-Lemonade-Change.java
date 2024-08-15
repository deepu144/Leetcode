class Solution {
    public boolean lemonadeChange(int[] bills) {
        int i=0;
        int n = bills.length;
        int[] fre = new int[3];
        while(i<n){
            if(bills[i]==5){
                fre[0]++;
            }else if(bills[i]==10){
                if(fre[0]>=1){
                    fre[0]--;
                    fre[1]++;
                }else{
                    return false;
                }
            }else if (bills[i]==20){
                if(fre[0]>=1 && fre[1]>=1){
                    fre[0]--;
                    fre[1]--;
                }else if (fre[0]>=3 && fre[1]==0){
                    fre[0]-=3;
                }
                else{
                    return false;
                }
            }
            i++;
        }
        return true;
    }
}