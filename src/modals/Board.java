package modals;
import java.util.ArrayList;
import java.util.List;

public class Board {

    List<List<Cell>> board;


    public Board(int dimensions)
    {
        board = new ArrayList<>();

        for(int i = 0; i < dimensions; i++)
        {
            board.add(new ArrayList<>());

            for(int j = 0; j < dimensions; j++)
            {
                board.get(i).add(new Cell(i, j));
            }
        }
    }

    public void display(){

        for (List<Cell> cells : board) {
            for (Cell cell : cells) {
                if (cell.getState().equals(CellState.EMPTY)) {
                    System.out.print("| |");
                } else {
                    System.out.println("| " + cell.getPlayer().getSymbol() + " |");
                }
            }
            System.out.println();
        }
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }
}
