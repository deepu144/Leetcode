class Solution {
    public String processStr(String s) {
        Stack<Character> st=new Stack<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch>='a' && ch<='z') st.push(ch);
            else if(!st.isEmpty()){
                if(ch=='*') st.pop();
                else if(ch=='#'){
                    List<Character> li=new ArrayList<>(st);
                    for(char c : li) st.push(c);
                }else if(ch=='%'){
                    Stack<Character> temp=new Stack<>();
                    while(!st.isEmpty()) temp.push(st.pop());
                    st=temp;
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()) sb.append(st.pop());
        return sb.reverse().toString();
    }
}