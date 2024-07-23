class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> li = new ArrayList<>();
        generate(li,n,n,n,new StringBuilder());
        return li;
    }

    public void generate(List<String> li,int n,int open,int close,StringBuilder sb){
        if(sb.length()==n*2){
            li.add(sb.toString());
            return;
        }
        if(open>0){
            sb.append('(');
            generate(li,n,open-1,close,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close>open){
            sb.append(')');
            generate(li,n,open,close-1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }

}