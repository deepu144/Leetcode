class Solution {
    public boolean parseBoolExpr(String ex) {
        Stack<Character> op=new Stack<>();
        Stack<Character> st=new Stack<>();
        int n=ex.length();
        for(int i=0;i<n;i++){
            char ch=ex.charAt(i); 
            if(ch=='!'||ch=='&'||ch=='|') op.push(ch);
            else if(ch=='('||ch=='t'||ch=='f') st.push(ch);
            else if(ch==')'){
                char operator=op.peek();
                Boolean res=null;
                while(st.peek()!='('){
                    char p=st.pop();
                    if(res==null) res = (p=='t'?true:false);
                    switch(operator){
                        case '&':
                            if(p=='t') res&=true;
                            else res&=false;
                            break;
                        case '|':
                            if(p=='t') res|=true;
                            else res|=false;
                            break;
                        case '!':
                            res=!res;
                            break;
                    }
                }
                st.pop();
                op.pop();
                st.push(res?'t':'f');
            }
        }
        return st.peek()=='t'?true:false;
    }
}