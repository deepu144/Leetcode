class neighborSum {
    private int[][] grid;
    private Map<Integer, int[]> valueToCoordinates;

    public neighborSum(int[][] grid) {
        this.grid = grid;
        this.valueToCoordinates = new HashMap<>();
        int n = grid.length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                valueToCoordinates.put(grid[i][j], new int[]{i, j});
            }
        }
    }
    
    public int adjacentSum(int value) {
        int[] coords = valueToCoordinates.get(value);
        if (coords == null) {
            return 0;
        }
        
        int row = coords[0];
        int col = coords[1];
        int sum = 0;
        
        if (row > 0) sum += grid[row - 1][col]; 
        if (row < grid.length - 1) sum += grid[row + 1][col]; 
        if (col > 0) sum += grid[row][col - 1]; 
        if (col < grid.length - 1) sum += grid[row][col + 1]; 
        
        return sum;
    }
    
    public int diagonalSum(int value) {
        int[] coords = valueToCoordinates.get(value);
        if (coords == null) {
            return 0; 
        }
        
        int row = coords[0];
        int col = coords[1];
        int sum = 0;
        
        if (row > 0 && col > 0) sum += grid[row - 1][col - 1]; 
        if (row > 0 && col < grid.length - 1) sum += grid[row - 1][col + 1];
        if (row < grid.length - 1 && col > 0) sum += grid[row + 1][col - 1]; 
        if (row < grid.length - 1 && col < grid.length - 1) sum += grid[row + 1][col + 1]; 
        
        return sum;
    }
}

/**
 * Your neighborSum object will be instantiated and called as such:
 * neighborSum obj = new neighborSum(grid);
 * int param_1 = obj.adjacentSum(value);
 * int param_2 = obj.diagonalSum(value);
 */

/**
 * Your neighborSum object will be instantiated and called as such:
 * neighborSum obj = new neighborSum(grid);
 * int param_1 = obj.adjacentSum(value);
 * int param_2 = obj.diagonalSum(value);
 */