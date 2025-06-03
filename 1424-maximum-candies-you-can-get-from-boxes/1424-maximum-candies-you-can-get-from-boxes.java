class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n=status.length,ans=0;
        Queue<Integer> q=new LinkedList<>();
        boolean[] boxAvailable=new boolean[n];
        boolean[] keysAvailable=new boolean[n];
        for(int box : initialBoxes){
            boxAvailable[box]=true;
            if(status[box]==1) q.offer(box);
        }
        while(!q.isEmpty()){
            int box = q.poll();
            if(status[box]==-1) continue;
            ans+=candies[box];
            status[box]=-1;
            for(int key : keys[box]){
                keysAvailable[key]=true;
                if(status[key]==0 && boxAvailable[key]) q.offer(key);
            }
            for(int containedBox : containedBoxes[box]){
                boxAvailable[containedBox]=true;
                if(status[containedBox]==1 || (status[containedBox]==0 && keysAvailable[containedBox])) q.offer(containedBox);
            }
        }
        return ans;
    }
}