class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        int size = logs.size(), lastTime = 0;
        Stack<Integer> callStack=new Stack<>();
        for(int i=0;i<size;i++){
            String[] s = logs.get(i).split(":");
            int currFun = Integer.parseInt(s[0]);
            int time = Integer.parseInt(s[2]);
            int len = s[1].length();
            if(len == 5){
                if(!callStack.isEmpty()) ans[callStack.peek()] += (time - lastTime);
                callStack.push(currFun);
                lastTime = time;
            }else{
                callStack.pop();
                ans[currFun] += (time - lastTime + 1);
                lastTime = time+1;
            }
        }
        return ans;
    }
}