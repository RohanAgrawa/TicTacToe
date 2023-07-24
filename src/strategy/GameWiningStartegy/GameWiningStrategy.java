package strategy.GameWiningStartegy;

import modals.Board;
import modals.Cell;
import modals.Player;

public interface GameWiningStrategy {

    public void undoWining(int row, int col, Player player, int dimensions);
    public boolean checkWinner(Board board, Player player, Cell cell);
}
