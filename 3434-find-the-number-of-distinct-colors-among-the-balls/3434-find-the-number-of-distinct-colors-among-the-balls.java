class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        HashMap<Integer,Integer> ball=new HashMap<>();
        HashMap<Integer,Integer> color=new HashMap<>();
        int count=0,n=queries.length;
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            int[] query=queries[i];
            int ballColor=ball.getOrDefault(query[0],-1);
            if(ballColor==-1){
                ball.put(query[0],query[1]);
                if(color.getOrDefault(query[1],-1)==-1) count++;
                color.put(query[1],color.getOrDefault(query[1],0)+1);
            }else if(ballColor!=query[1]){
                if(color.getOrDefault(ballColor,-1)!=-1){
                    color.put(ballColor,color.get(ballColor)-1);
                    if(color.get(ballColor)==0){
                        count--;
                        color.remove(ballColor);
                    }
                }
                if(color.getOrDefault(query[1],-1)==-1) count++;
                ball.put(query[0],query[1]);
                color.put(query[1],color.getOrDefault(query[1],0)+1);
            }
            res[i]=count;
        }
        return res;
    }
}