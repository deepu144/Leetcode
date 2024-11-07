/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        int n=grid.length;
        int[][] prefix=new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            int sum=0;
            for(int j=1;j<=n;j++){
                sum+=grid[i-1][j-1];
                prefix[i][j]=sum+prefix[i-1][j];
            }
        }
        return construct(grid,0,0,n,prefix);
    }
    public Node construct(int[][] grid,int x,int y,int val,int[][] prefix){
        if(val==1) return new Node(grid[x][y]==1,true);
        int half = val / 2;
        int sumTopLeft = calculateSum(prefix, x, y, x + half - 1, y + half - 1);
        int sumTopRight = calculateSum(prefix, x, y + half, x + half - 1, y + val - 1);
        int sumBottomLeft = calculateSum(prefix, x + half, y, x + val - 1, y + half - 1);
        int sumBottomRight = calculateSum(prefix, x + half, y + half, x + val - 1, y + val - 1);
        Node topLeft = (sumTopLeft == half * half || sumTopLeft == 0) 
                        ? new Node(sumTopLeft == half * half, true) 
                        : construct(grid, x, y, half, prefix);
        
        Node topRight = (sumTopRight == half * half || sumTopRight == 0) 
                        ? new Node(sumTopRight == half * half, true) 
                        : construct(grid, x, y + half, half, prefix);
        
        Node bottomLeft = (sumBottomLeft == half * half || sumBottomLeft == 0) 
                          ? new Node(sumBottomLeft == half * half, true) 
                          : construct(grid, x + half, y, half, prefix);
        
        Node bottomRight = (sumBottomRight == half * half || sumBottomRight == 0) 
                           ? new Node(sumBottomRight == half * half, true) 
                           : construct(grid, x + half, y + half, half, prefix);        
        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf &&
            topLeft.val == topRight.val && topLeft.val == bottomLeft.val && topLeft.val == bottomRight.val) {
            return new Node(topLeft.val, true);
        }
        Node node = new Node(false, false);
        node.topLeft = topLeft;
        node.topRight = topRight;
        node.bottomLeft = bottomLeft;
        node.bottomRight = bottomRight;
        return node;
    }
    private int calculateSum(int[][] prefix, int x1, int y1, int x2, int y2) {
        return prefix[x2 + 1][y2 + 1] - prefix[x1][y2 + 1] - prefix[x2 + 1][y1] + prefix[x1][y1];
    }
}