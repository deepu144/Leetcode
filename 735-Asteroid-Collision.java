class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int n : asteroids){
            if(!st.isEmpty()){
                int pre = st.peek();
                if(pre>0 && n<0){
                    if(pre==-1*n) st.pop();
                    else if(pre<-1*n){
                        int t = -1;
                        while(!st.isEmpty() && (st.peek()>0) && (st.peek()<=-1*n)){
                            t=st.pop();
                            if(t==-1*n) break;
                        }
                        if(t!=n*-1 && (st.isEmpty() || st.peek()<0)){
                            st.push(n);
                        }
                    }continue;
                }
            }
            st.push(n);
        }
        return st.stream().mapToInt(i->i).toArray();
    }
}