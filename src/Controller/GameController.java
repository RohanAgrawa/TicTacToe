package Controller;
import exceptions.InvalidGameBuildException;
import modals.*;

import java.util.List;

public class GameController{

    public Game createGame(int dimensions, List<Player> player) {

        try {
            return new Game.Builder()
                    .setPlayer(player)
                    .setDimensions(dimensions)
                    .Build();
        }
        catch (InvalidGameBuildException e){
            return null;
        }
    }

    public void undo(Game game){

    }

    public void displayBoard(Game game){
        game.displayBoard();
    }

    public Player getWinner(Game game){

        return game.getWinner();
    }

    public void executeNextMove(Game game){
        game.makeNextMove();
    }

    public GameStatus getGameStatus(Game game){
        return game.getStatus();
    }
}
