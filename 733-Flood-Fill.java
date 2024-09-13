class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m=image.length,n=image[0].length,ch=image[sr][sc];
        if(ch==color) return image;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr,sc});
        int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] arr = q.poll();
                for(int[] d : dir){
                    int x=d[0]+arr[0];
                    int y=d[1]+arr[1];
                    if(x<0 || x>=m || y<0 || y>=n || image[x][y]!=ch) continue;
                    image[x][y]=color;
                    q.offer(new int[]{x,y});
                }
            }
        }
        image[sr][sc]=color;
        return image;
    }
}