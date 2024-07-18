class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        int[] dig = new int[n];
        for(int i=0;i<n;i++){
            dig[i]=num.charAt(i)-'0';
        }
        Stack<Integer> st = new Stack<>();
        int t =-1;
        for(int i=0;i<n;i++){
            boolean f=false;
            if(!st.isEmpty()){
                while(!st.isEmpty() && st.peek()>dig[i]){
                    st.pop();
                    k--;
                    if(k==0){
                        f=true;
                        t=i;
                        break;
                    }
                }
                if(f) break;
            }
            st.push(dig[i]);
        }
        StringBuilder sb = new StringBuilder();
        for(int i : st){
            sb.append(i);
        }
        if(t!=-1){
            for(int i=t;i<n;i++){
                sb.append(dig[i]);
            }
        }
        String str = sb.toString();
        if(k!=0){
            String ss = str.substring(0,str.length()-k);
            if(ss.length()==0){
                return \0\;
            }
            str=ss;
        }
        if(str.length()==1)
            return str;
        int i = 0;
        while (i < str.length() && str.charAt(i) == '0') {
            i++;
        }
        sb = new StringBuilder(str);
        sb.replace(0, i, \\);
        return sb.length()==0?\0\:sb.toString();
    }
}