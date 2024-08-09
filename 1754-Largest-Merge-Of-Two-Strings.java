class Solution {
    public String largestMerge(String word1, String word2) {
        StringBuilder sb=new StringBuilder();
        char[] x=word1.toCharArray();
        char[] y=word2.toCharArray();
        int n=x.length,m=y.length,a=0,b=0;
        boolean f=false;
        while(a<n && b<m){
            if(x[a]>y[b]) sb.append(x[a++]);
            else if(x[a]<y[b]) sb.append(y[b++]);
            else if(x[a]==y[b]){
                int t = word1.substring(a).compareTo(word2.substring(b));
                if(t>0) sb.append(x[a++]);
                else sb.append(y[b++]);
            }
        }
        sb.append(word2.substring(b));
        sb.append(word1.substring(a));
        return sb.toString();
    }
}