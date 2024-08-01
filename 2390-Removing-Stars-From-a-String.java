class Solution {
    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='*') st.pop();
            else st.push(c);
        }
        StringBuilder sb = new StringBuilder();
        for(Character ch : st) sb.append(ch);
        return sb.toString();
    }
}