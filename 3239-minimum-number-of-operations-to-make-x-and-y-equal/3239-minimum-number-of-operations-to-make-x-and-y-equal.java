class Solution {
    public int minimumOperationsToMakeEqual(int x, int y) {
        if(y>=x) return y-x;
        Queue<Integer> q=new LinkedList<>();
        Set<Integer> set=new HashSet<>();
        int step=0;
        q.add(x);
        while(!q.isEmpty()){
            int size=q.size();
            step++;
            for(int i=0;i<size;i++){
                int p=q.poll();
                if(!set.add(p)) continue;
                if(p+1==y || p-1==y) return step;
                if(p%5==0){
                    if(p/5==y) return step;
                    else q.add(p/5);
                }
                if(p%11==0){
                    if(p/11==y) return step;
                    else q.add(p/11);
                }
                q.add(p+1);
                q.add(p-1);
            }
        }
        return step;
    }
}