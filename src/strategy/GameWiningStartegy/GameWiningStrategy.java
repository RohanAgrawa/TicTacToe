package strategy.GameWiningStartegy;

import modals.Board;
import modals.Cell;
import modals.Player;

public interface GameWiningStrategy {

    public boolean checkWinner(Board board, Player player, Cell cell);
}
