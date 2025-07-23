class Solution {
    public int maximumGain(String s, int x, int y) {
        int n=s.length();
        if(y<=x) return helper(s,n,x,y,'a','b');
        return helper(s,n,y,x,'b','a');
    }
    public int helper(String s,int n,int x,int y,char top,char expect){
        Stack<Character> st=new Stack<>();
        int points=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch==expect){
                if(!st.isEmpty() && st.peek()==top){
                    points+=x;
                    st.pop();
                }else st.push(ch);
            }else st.push(ch);
        }
        points+=helper(st,y,top,expect);
        return points;
    }
    public int helper(Stack<Character> st,int points,char top,char expect){
        int remainPoints=0;
        Stack<Character> newStack=new Stack<>();
        while(!st.isEmpty()){
            char ch=st.pop();
            if(ch==expect){
                if(!newStack.isEmpty() && newStack.peek()==top){
                    newStack.pop();
                    remainPoints+=points;
                }else newStack.push(ch);
            }else newStack.push(ch);
        }
        return remainPoints;
    }
}