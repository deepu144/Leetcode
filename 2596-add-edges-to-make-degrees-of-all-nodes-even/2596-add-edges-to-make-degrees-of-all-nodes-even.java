class Solution {
    record Pair(int u,int v){}
    public boolean isPossible(int n, List<List<Integer>> edges) {
        int[] degree=new int[n+1];
        Set<Pair> set=new HashSet<>();
        for(List<Integer> edge : edges){
            set.add(new Pair(edge.getFirst(),edge.getLast()));
            set.add(new Pair(edge.getLast(),edge.getFirst()));
            degree[edge.getFirst()]++;
            degree[edge.getLast()]++;
        }
        int oddDegree=0,k=0;
        int[] odd=new int[4];
        for(int i=1;i<=n;i++){
            if((degree[i]&1)==1){
                oddDegree++;
                if(k==4) return false;
                odd[k++]=i;
            }
        }
        if(oddDegree==2){
            if(!set.contains(new Pair(odd[0],odd[1]))) return true;
            for(int i=1;i<n;i++){
                if(i!=odd[0] && i!=odd[1] && !set.contains(new Pair(odd[0],i)) && !set.contains(new Pair(i,odd[1]))){
                    return true;
                }
            }
            return false;
        }
        if(oddDegree>4) return false;
        return (!set.contains(new Pair(odd[0],odd[1])) && !set.contains(new Pair(odd[2],odd[3]))) ||
                (!set.contains(new Pair(odd[0],odd[2])) && !set.contains(new Pair(odd[1],odd[3]))) ||
                (!set.contains(new Pair(odd[0],odd[3])) && !set.contains(new Pair(odd[2],odd[1])));
    }
}