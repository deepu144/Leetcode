class Solution {
    public int leastInterval(char[] tasks, int n){
        int res=0;
        Map<Character,Integer> map= new HashMap<>();
        for(int i=0;i<tasks.length;i++) map.put(tasks[i],map.getOrDefault(tasks[i],0)+1);
        PriorityQueue<Integer> pq = new PriorityQueue<>(map.size(),Collections.reverseOrder());
        pq.addAll(map.values());
        while(!pq.isEmpty()){
            ArrayList<Integer> li=new ArrayList<>();
            int t=0;
            for(int i=0;i<n+1;i++){
                if(!pq.isEmpty()){
                    li.add(pq.remove()-1);
                    t++;
                }
            }
            for(int i : li) if(i>0) pq.add(i);
            res+= pq.isEmpty()?t:n+1;
        }
        return res;
    }
}