class Solution {
    final String L="/";
    public String simplifyPath(String path) {
        Stack<String> stack=new Stack<>();
        path=path+L;
        int st=1,n=path.length();
        for(int i=1;i<n;i++){
            if(path.charAt(i)=='/'){
                String s=path.substring(st,i);
                if(s.equals(".")) st=i+1;
                else if(s.equals("..")){
                    st=i+1;
                    if(!stack.isEmpty()) stack.pop();
                }
                else if(st!=i){
                    stack.push(s);
                    st=i+1;
                }else if(st==i) st=i+1;
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty()) sb.insert(0,stack.pop()+L);
        if(sb.length()>1) sb.deleteCharAt(sb.length()-1);
        sb.insert(0,L);
        return sb.toString();
    }
}