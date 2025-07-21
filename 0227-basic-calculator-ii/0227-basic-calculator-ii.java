class Solution {
    public int calculate(String s) {
        Stack<Character> operator=new Stack<>();
        Stack<Integer> value=new Stack<>();
        int n=s.length(),i=0;
        while(i<n){
            long operand=0L;
            while(i<n){
                char digit=s.charAt(i);
                if(digit>='0' && digit<='9') operand = (operand*10L)+(digit-'0');
                else if(digit!=' ') break;
                i++;
            }
            if(!operator.isEmpty() && isTopPriority(operator.peek())){
                int intermediateResult = getIntermediateResult(value.pop(),(int)operand,operator.pop(),false);
                value.push(intermediateResult);
            }else value.push((int)operand);
            if(i>=n) break;
            char oper = s.charAt(i++);
            operator.push(oper);
        }
        operator = reverse(operator);
        value = reverse(value);
        while(value.size()>1){
            int b=value.pop(),a=value.pop();
            int intermediateResult = getIntermediateResult(a,b,operator.pop(),true);
            value.push(intermediateResult);
        }
        return value.pop();
    }
    public boolean isTopPriority(char ch){
        return ch=='*' || ch=='/';
    }
    public int getIntermediateResult(int a, int b, char operator,boolean flag){
        int c=0;
        switch(operator){
            case '*':
                c=a*b;
                break;
            case '/':
                c=a/b;
                break;
            case '+':
                c=a+b;
                break;
            case '-':
                if(flag) c=b-a;
                else c=a-b;
                break;
        }
        return c;
    }
    public <T> Stack<T> reverse(Stack<T> st){
        Stack<T> temp = new Stack<>();
        while(!st.isEmpty()) temp.push(st.pop());
        return temp;
    }
}