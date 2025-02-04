class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source==target) return 0;
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        Queue<Integer> q=new LinkedList<>();
        Set<Integer> visitedRoute=new HashSet<>();
        Set<Integer> visitedStop=new HashSet<>();
        int n=routes.length,buses=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<routes[i].length;j++){
                map.computeIfAbsent(routes[i][j],p->new ArrayList<>()).add(i);
            }
        }
        if(!map.containsKey(target)) return -1;
        for(int startRoute : map.getOrDefault(source,new ArrayList<>())){
            q.offer(startRoute);
            visitedRoute.add(startRoute);
        }
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int route=q.poll();
                for(int stop : routes[route]){
                    if(stop==target) return buses;
                    if(!visitedStop.add(stop)) continue;
                    for(int nextRoute : map.getOrDefault(stop,new ArrayList<>())){
                        if(!visitedRoute.add(nextRoute)) continue;
                        q.offer(nextRoute);
                    }
                }
            }
            buses++;
        }
        return -1;
    }
}