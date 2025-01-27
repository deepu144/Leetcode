//1462
class Solution {
    record Pair(Integer node,List<Integer> parent){}
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        if(prerequisites.length==0) return new ArrayList<>(Collections.nCopies(queries.length,false));
        List<Boolean> ans=new ArrayList<>();
        List<Integer>[] adj=new List[numCourses];
        for(int i=0;i<numCourses;i++) adj[i]=new ArrayList<>();
        int[] inDegree=new int[numCourses];
        for(int[] a : prerequisites){
            adj[a[0]].add(a[1]);
            inDegree[a[1]]++;
        }
        Queue<Integer> q=new LinkedList<>();
        Set<Integer>[] reach=new Set[numCourses];
        for(int i=0;i<numCourses;i++) reach[i]=new HashSet<>();
        for(int i=0;i<numCourses;i++) if(inDegree[i]==0) q.offer(i);
        while(!q.isEmpty()){
            int p=q.poll();
            for(int n : adj[p]){
                reach[n].add(p);
                reach[n].addAll(reach[p]);
                inDegree[n]--;
                if(inDegree[n]==0) q.offer(n);
            }
        }
        for(int[] a : queries) ans.add(reach[a[1]].contains(a[0]));
        return ans;
    }
}