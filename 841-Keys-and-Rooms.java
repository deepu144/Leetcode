class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        boolean[] visited=new boolean[n];
        Queue<Integer> q=new LinkedList<>();
        q.offer(0);
        while(!q.isEmpty()){
            int p=q.poll();
            visited[p]=true;
            for(int i : rooms.get(p)){
                if(!visited[i]){
                    q.offer(i);
                }
            }
        }
        for(int i=0;i<n;i++) if(!visited[i]) return false;
        return true;
    }
}