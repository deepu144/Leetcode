class Solution {
    public long subArrayRanges(int[] arr) {
        int n = arr.length;
        Stack<Pair<Integer,Integer>> st = new Stack<>();
        int[] leftmin = new int[n];
        int[] rightmin = new int[n];
        for(int i=0;i<n;i++){
            int cnt=1;
            while(!st.isEmpty() && arr[i]<st.peek().getKey()){
                cnt+=st.pop().getValue();
            }
            st.push(new Pair<>(arr[i],cnt));
            leftmin[i]=cnt;
        }
        st.clear();
        for(int i=n-1;i>=0;i--){
            int cnt=1;
            while(!st.isEmpty() && arr[i]<=st.peek().getKey()){
                cnt+=st.pop().getValue();
            }
            st.push(new Pair<>(arr[i],cnt));
            rightmin[i]=cnt;
        }
        st.clear();
        int[] leftmax = new int[n];
        int[] rightmax = new int[n];
        for(int i=0;i<n;i++){
            int cnt=1;
            while(!st.isEmpty() && arr[i]>st.peek().getKey()){
                cnt+=st.pop().getValue();
            }
            st.push(new Pair<>(arr[i],cnt));
            leftmax[i]=cnt;
        }
        st.clear();
        for(int i=n-1;i>=0;i--){
            int cnt=1;
            while(!st.isEmpty() && arr[i]>=st.peek().getKey()){
                cnt+=st.pop().getValue();
            }
            st.push(new Pair<>(arr[i],cnt));
            rightmax[i]=cnt;
        }
        long[] ans = new long[n];
        long res=1;
        for(int i=0;i<n;i++){
            ans[i] = ((long)leftmax[i]*rightmax[i])-((long)leftmin[i]*rightmin[i]);
            res+=(ans[i]*arr[i]);
        }
        return --res;
    }
}