class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String s:tokens){
            char ch=s.charAt(s.length()-1);
            if(ch!='+'&&ch!='-'&&ch!='*'&&ch!='/'){
                st.push(Integer.parseInt(s));
            }else{
                int num2=st.pop();
                int num1=st.pop();
                if(ch=='+') st.push(num1+num2);
                else if(ch=='-') st.push(num1-num2);
                else if(ch=='*') st.push(num1*num2);
                else st.push(num1/num2);
            }
        }
        return st.pop();
    }
}