package forer.maze;

public class Cell {

    private boolean NWall;
    private boolean EWall;
    private boolean SWall;
    private boolean WWall;
    private int row;
    private int col;
    private boolean visited;

    public Cell(int row, int col){
        this.row = row;
        this.col = col;
        NWall = true;
        EWall = true;
        SWall = true;
        WWall = true;
    }
    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }



    public boolean isNWall() {
        return NWall;
    }

    public void setNWall(boolean NWall) {
        this.NWall = NWall;
    }

    public boolean isEWall() {
        return EWall;
    }

    public void setEWall(boolean EWall) {
        this.EWall = EWall;
    }

    public boolean isSWall() {
        return SWall;
    }

    public void setSWall(boolean SWall) {
        this.SWall = SWall;
    }

    public boolean isWWall() {
        return WWall;
    }

    public void setWWall(boolean WWall) {
        this.WWall = WWall;
    }
}