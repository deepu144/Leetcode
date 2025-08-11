class Solution {
    public static final long MOD=(long)(1e9+7);
    public int[] productQueries(int n, int[][] queries){
        List<Double> powers=new ArrayList<>();
        List<Double> prefix=new ArrayList<>();
        helper(powers,prefix,n);
        int m=queries.length;
        int[] res = new int[m];
        for(int i=0;i<m;i++){
            int st=queries[i][0],end=queries[i][1]+1;
            res[i] =(int)((prefix.get(end)/prefix.get(st))%MOD);
        }
        return res;
    }
    public void helper(List<Double> powers,List<Double> prefix,int n){
        int p=0;
        Double curr=1.0D;
        prefix.add(curr);
        while(n>0){
            boolean isSet = (n%2==1);
            if(isSet){
                Double val = (double)(1L << p);
                curr = (curr * val);
                powers.add(val);
                prefix.add(curr);
            }
            n >>= 1;
            p++;
        }
    }
}