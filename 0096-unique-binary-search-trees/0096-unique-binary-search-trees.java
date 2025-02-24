class Solution {
    public int numTrees(int n) {
        double res=1,a=n*2;
        for(int i=n;i>=2;i--,a--) res*=a/i;
        return (int)Math.round(res);
    }
}