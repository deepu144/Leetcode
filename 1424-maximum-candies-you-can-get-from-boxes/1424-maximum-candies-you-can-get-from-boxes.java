class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n=status.length,tot=0;
        Queue<Integer> q=new LinkedList<>();
        boolean[] boxAvailable=new boolean[n];
        boolean[] keyAvailable=new boolean[n];
        for(int initialBox : initialBoxes){
            boxAvailable[initialBox]=true;
            if(status[initialBox]==1) q.offer(initialBox);
        }
        while(!q.isEmpty()){
            int box=q.poll();
            if(status[box]==-1) continue;
            tot+=candies[box];
            for(int key : keys[box]){
                keyAvailable[key]=true;
                if(boxAvailable[key]==true && status[key]==0) q.offer(key);
            }
            for(int containedBox : containedBoxes[box]){
                boxAvailable[containedBox]=true;
                if(status[containedBox]==1 || (keyAvailable[containedBox] && status[containedBox]==0)) q.offer(containedBox);
            }
            status[box]=-1;
        }
        return tot;
    }
}