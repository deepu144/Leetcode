class CustomStack {
    int[] st;
    int top,size;
    public CustomStack(int maxSize) {
        st=new int[maxSize];
        top=-1;
        size=maxSize;
    }
    
    public void push(int x) {
        if(top==-1) st[++top]=x;
        else if(top+1!=size) st[++top]=x;
    }
    
    public int pop() {
        if(top==0) return st[top--];
        else if(top!=-1) return st[top--];
        else return -1;
    }
    
    public void increment(int k, int val) {
        if(top+1<=k) for(int i=0;i<=top;i++) st[i]+=val;
        else for(int i=0;i<k;i++) st[i]+=val;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */