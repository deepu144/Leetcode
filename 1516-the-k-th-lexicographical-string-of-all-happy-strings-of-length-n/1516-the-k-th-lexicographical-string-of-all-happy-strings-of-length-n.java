class Solution {
    final static char[] ch={'a','b','c'};
    public String getHappyString(int n, int k){
        List<String> ans=new ArrayList<>();
        generate(0,n,new StringBuilder(),ans,k);
        if(ans.size()<k) return "";
        return ans.getLast();
    }
    public void generate(int i,int n,StringBuilder sb,List<String> li,int k){
        if(li.size()==k) return;
        if(i==n){
            li.add(sb.toString());
            return;
        }
        for(int j=0;j<3;j++){
            if(i==0||sb.charAt(i-1)!=ch[j]){
                sb.append(ch[j]);
                generate(i+1,n,sb,li,k);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}