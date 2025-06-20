class Solution {
    final char[][] diagonal= {{'N','E'},{'N','W'},{'S','E'},{'S','W'}};
    public int maxDistance(String s, int k) {
        int n=s.length(),max=0;
        for(char[] dir : diagonal) max=Math.max(max, helper(s,n,k,dir[0],dir[1]) );
        return max;
    }
    public int helper(String s,int n,int k,char a,char b){
        int step=0,badStep=0,max=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch==a || ch==b) step++;
            else{
                step--;
                badStep++;
            }
            int possible = step + 2 * Math.min(k,badStep);
            max=Math.max(max,possible);
        }
        return max;
    }
}