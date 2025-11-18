class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length, i = 0;
        while(i<n){
            if(bits[i] == 1){
                i++;
                if(i>=n) return false;
                i++;
                if(i>=n) return false;
            }else i++;
        }
        return true;
    }
}