class Solution {
    final String BLANK="";
    public int calculate(String s) {
        int n=s.length(),i=0,sign=1,res=0;
        Stack<Integer> st=new Stack<>();
        while(i<n){
            char ch=s.charAt(i);
            if(Character.isDigit(ch)){
                int a=ch-'0';
                while(i+1<n && Character.isDigit(ch=s.charAt(i+1))){
                    a*=10;
                    a+=(ch-'0');
                    i++;
                }
                res+=(sign*a);
            }else if(ch=='+') sign=1;
            else if(ch=='-') sign=-1;
            else if(ch=='('){
                st.push(res);
                st.push(sign);
                res=0;
                sign=1;
            }else if(ch==')') res=(res*st.pop())+st.pop();
            i++;
        }
        return res;
    }
}