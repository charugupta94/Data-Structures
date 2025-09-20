class Spreadsheet {
    private int[][] grid; 
    private int rows;
    public Spreadsheet(int rows) {
        this.rows = rows;
        grid = new int[rows][26];
    }
    
    private int[] parseCell(String cell) {
        int col = cell.charAt(0) - 'A';  
        int row = Integer.parseInt(cell.substring(1)) - 1; 
        return new int[]{row, col};
    }
    
    public void setCell(String cell, int value) {
        int[] rc = parseCell(cell);
        grid[rc[0]][rc[1]] = value;
    }
    
    public void resetCell(String cell) {
        int[] rc = parseCell(cell);
        grid[rc[0]][rc[1]] = 0;
    }
    
    public int getValue(String formula) {
        String expr = formula.substring(1);
        String[] parts = expr.split("\\+");
        int sum = 0;
        for (String part : parts) {
            if (Character.isLetter(part.charAt(0))) {
                int[] rc = parseCell(part);
                sum += grid[rc[0]][rc[1]];
            } else { 
                sum += Integer.parseInt(part);
            }
        }
        return sum;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */