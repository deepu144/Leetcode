class MyQueue {
    
    public Stack<Integer> st;
    public Stack<Integer> dummy;
    public MyQueue() {
        st = new Stack<>();
        dummy = new Stack<>();
    }
    
    public void push(int x) {
        st.push(x);
    }
    
    public int pop() {
        while(!st.isEmpty()) dummy.push(st.pop());
        int pop = dummy.pop();
        while(!dummy.isEmpty()) st.push(dummy.pop());
        return pop;
    }
    
    public int peek() {
        while(!st.isEmpty()) dummy.push(st.pop());
        int peek = dummy.peek();
        while(!dummy.isEmpty()) st.push(dummy.pop());
        return peek;
    }
    
    public boolean empty() {
        return st.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */