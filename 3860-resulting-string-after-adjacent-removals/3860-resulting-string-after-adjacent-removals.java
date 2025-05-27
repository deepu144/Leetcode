class Solution {
    public String resultingString(String s) {
        Stack<Character> st=new Stack<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            boolean canAdd=true;
            if(!st.isEmpty()){
                char prev = st.peek();
                if(isAdjacentCharacters(prev-'a',ch-'a')){
                    st.pop();
                    canAdd=false;
                }
            }
            if(canAdd) st.push(ch);
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()) sb.append(st.pop());
        return sb.reverse().toString();
    }
    public boolean isAdjacentCharacters(int a,int b) {
        if(a-b==1 || b-a==1 || (a==0 && b==25) || (a==25 && b==0)) return true;
        return false;
    }
}