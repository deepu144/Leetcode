class Solution {
    public int largestRectangleArea(int[] arr) {
        int n = arr.length;
        int[] leftMin = new int[n];
        int[] rightMin = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]) st.pop();
            if(st.isEmpty()) leftMin[i]=-1;
            else leftMin[i]=st.peek();
            st.push(i);
        }
        st.clear();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]) st.pop();
            if(st.isEmpty()) rightMin[i]=n;
            else rightMin[i]=st.peek();
            st.push(i);
        }
        int max=-1;
        for(int i=0;i<n;i++) max=Math.max(max,(rightMin[i]-leftMin[i]-1)*arr[i]);
        return max;
    }
}