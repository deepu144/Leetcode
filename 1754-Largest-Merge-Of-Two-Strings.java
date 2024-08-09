class Solution {
    public String largestMerge(String word1, String word2) {
        List<Character> li = new ArrayList<>();
        char[] x=word1.toCharArray();
        char[] y=word2.toCharArray();
        int n=x.length,m=y.length,a=0,b=0;
        boolean f=false;
        while(a<n && b<m){
            if(x[a]>y[b]) li.add(x[a++]);
            else if(x[a]<y[b]) li.add(y[b++]);
            else if(x[a]==y[b]){
                int t = word1.substring(a).compareTo(word2.substring(b));
                if(t>0) li.add(x[a++]);
                else li.add(y[b++]);
            }
        }
        StringBuilder sb=new StringBuilder();
        for(char ch : li) sb.append(ch);
        if(a==n && b!=m){
            sb.append(word2.substring(b));
            return sb.toString();
        }else if(a!=n && b==m){
            sb.append(word1.substring(a));
            return sb.toString();
        }
        return sb.toString();
    }
}