class Spreadsheet {
    int[][] mat;
    public Spreadsheet(int rows) {
        mat = new int[rows][26];
    }
    
    public void setCell(String cell, int value) {
        int col = getCol(cell), row = getRow(cell);
        mat[row][col] = value;
    }
    
    public void resetCell(String cell) {
        int col = getCol(cell), row = getRow(cell);
        mat[row][col] = 0;
    }

    public int getCellValue(String cell){
        int col = getCol(cell), row = getRow(cell);
        return mat[row][col];
    }

    public int getRow(String cell){
        return Integer.parseInt(cell.substring(1))-1;
    }

    public int getCol(String cell){
        return cell.charAt(0)-'A';
    }
    
    public int getValue(String formula) {
        String[] cells = formula.substring(1).split("\\+");
        int a=0,b=0;
        if(Character.isLetter(cells[0].charAt(0))) a = getCellValue(cells[0]);
        else a = Integer.parseInt(cells[0]);

        if(Character.isLetter(cells[1].charAt(0))) b = getCellValue(cells[1]);
        else b = Integer.parseInt(cells[1]);

        return a+b;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */