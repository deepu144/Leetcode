class Solution {
    static final String PUSH = "Push";
    static final String POP = "Pop";
    public List<String> buildArray(int[] target, int n) {
        int curr = 1, top = 0, m = target.length;
        int[] stack = new int[n+1];
        List<String> ans = new ArrayList<>();
        while(top < m){
            while(stack[top] != target[top]){
                if(stack[top] != 0) ans.add(POP);
                stack[top] = curr++;
                ans.add(PUSH);
            }
            top++;
        }
        return ans;
    }
}