class Solution {
    public int[] findOrder(int num, int[][] course) {
        List<List<Integer>> li = new ArrayList<>();
        for(int i=0;i<num;i++) li.add(new ArrayList<>());
        for(int i=0;i<course.length;i++){
            li.get(course[i][1]).add(course[i][0]);
        }
        int[] inDegree=new int[num];
        for(int i=0;i<num;i++){
            for(int n : li.get(i)){
                inDegree[n]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<num;i++) if(inDegree[i]==0) q.offer(i);
        int[] ans = new int[num];
        int j=0;
        while(!q.isEmpty()){
            int p=q.poll();
            ans[j++]=p;
            for(int n : li.get(p)){
                inDegree[n]--;
                if(inDegree[n]==0) q.offer(n);
            }
        }
        if(j==num) return ans;
        return new int[]{};
    }
}