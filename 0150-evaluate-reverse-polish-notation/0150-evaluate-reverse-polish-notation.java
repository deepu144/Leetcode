class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st=new Stack<>();
        int n = tokens.length;
        for(int i=0;i<n;i++){
            char operator = tokens[i].charAt(tokens[i].length()-1);
            if(isOperator(operator)){
                int b = st.pop();
                int a = st.pop();
                a = evaluate(a,b,operator);
                st.push(a);
            }else{
                int val = Integer.parseInt(tokens[i]);
                st.push(val);
            }
        }
        return st.pop();
    }
    public boolean isOperator(char ch){
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }
    public int evaluate(int a, int b, char operator){
        return switch(operator){
            case '+' -> a+b;
            case '-' -> a-b;
            case '*' -> a*b;
            case '/' -> a/b;
            default  -> 0;
        };
    }
}