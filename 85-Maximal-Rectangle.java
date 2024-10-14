class Solution {
    public int maximalRectangle(char[][] mat) {
        int c=mat[0].length,res=-1;;
        int[] arr=new int[c];
        for(char[] ch : mat){
            for(int i=0;i<c;i++){
                int val=ch[i]-'0';
                if(val==0) arr[i]=0;
                else arr[i]+=val;
            }
            res=Math.max(res,max(c,arr));
        }
        return res;
    }
    public int max(int c,int[] arr){
        int[] leftMin = new int[c];
        int[] rightMin = new int[c];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<c;i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                leftMin[i]=-1;
            }else{
                leftMin[i]=st.peek();
            }
            st.push(i);
        }
        st.clear();
        for(int i=c-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                rightMin[i]=c;
            }else{
                rightMin[i]=st.peek();
            }
            st.push(i);
        }
        int max=-1;
        for(int i=0;i<c;i++){
            max=Math.max(max,(rightMin[i]-leftMin[i]-1)*arr[i]);
        }
        return max;
    }
}