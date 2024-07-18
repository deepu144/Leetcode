class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Pair<Integer,Integer>> st = new Stack<>();
        for(int i=0;i<n;i++){
            int cnt=1;
            while(!st.isEmpty() && arr[i]<st.peek().getKey()){
                cnt+=st.pop().getValue();
            }
            st.push(new Pair<>(arr[i],cnt));
            left[i]=cnt;
        }
        st.clear();
        for(int i=n-1;i>=0;i--){
            int cnt=1;
            while(!st.isEmpty() && arr[i]<=st.peek().getKey()){
                cnt+=st.pop().getValue();
            }
            st.push(new Pair<>(arr[i],cnt));
            right[i]=cnt;
        }
        long res = 1;
        long MOD = 1000000007;
        for (int i = 0; i < n; i++) {
            res = (res + (arr[i] * left[i] % MOD * right[i] % MOD) % MOD) % MOD;
        }
        res = (res - 1 + MOD) % MOD;
        return (int) res;
    }
}