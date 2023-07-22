package modals;

public class Cell {

    private int row;

    private int col;

    private Player player;

    private  CellState cellState;

    public Cell(int row, int col, Player player, CellState cellState){
        this.row = row;
        this.col = col;
        this.player = player;
        this.cellState = cellState;
    }

    public Cell(int row, int col)
    {
        this.row = row;
        this.col = col;
        cellState = CellState.EMPTY;
    }


    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public CellState getState() {
        return cellState;
    }

    public void setState(CellState state) {
        this.cellState = state;
    }
}
