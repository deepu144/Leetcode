class Solution {
    public String clearDigits(String s) {
        Stack<Character> st=new Stack<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(Character.isDigit(ch)) st.pop();
            else st.push(ch);
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()) sb.append(st.pop());
        return sb.reverse().toString();
    }
}