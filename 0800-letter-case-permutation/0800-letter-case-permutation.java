class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans=new ArrayList<>();
        generate(s,s.length()-1,ans,new StringBuilder());
        return ans;
    }
    public void generate(String s,int i,List<String> ans,StringBuilder sb){
        if(i==-1){
            ans.add(sb.toString());
            return;
        }
        char ch=s.charAt(i);
        if(Character.isDigit(ch)){
            sb.insert(0,ch);
            generate(s,i-1,ans,sb);
            sb.deleteCharAt(0);
        }else{
            sb.insert(0,Character.toUpperCase(ch));
            generate(s,i-1,ans,sb);
            sb.deleteCharAt(0);
            sb.insert(0,Character.toLowerCase(ch));
            generate(s,i-1,ans,sb);
            sb.deleteCharAt(0);
        }
    }
}