class Solution {
    final static char[] ch={'a','b','c'};
    public void generate(int i,int n,StringBuilder sb,List<String> li){
        if(i==n){
            li.add(sb.toString());
            return;
        }
        for(int j=0;j<3;j++){
            if(i==0||sb.charAt(i-1)!=ch[j]){
                sb.append(ch[j]);
                generate(i+1,n,sb,li);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
    public String getHappyString(int n, int k) {
        List<String> ans=new ArrayList<>();
        generate(0,n,new StringBuilder(),ans);
        System.out.println(ans);
        if(ans.size()<k) return "";
        return ans.get(k-1);
    }
}