package forer.maze;


public class Girl {
    private int row;
    private int col;

    public Girl(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getColumn() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int col) {
        this.col = col;
    }
}
