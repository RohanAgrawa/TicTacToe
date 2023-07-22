package modals;

import exceptions.InvalidGameBuildException;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private Board board;

    private List<Player> player;

    private List<List<Move>> move;

    private int nextPlayerIndex;

    private GameStatus status;

    private Player winner;

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }



    public List<List<Move>> getMove() {
        return move;
    }

    public void setMove(List<List<Move>> move) {
        this.move = move;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public GameStatus getStatus() {
        return status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public void displayBoard(){
        board.display();
    }

    public List<Player> getPlayer() {
        return player;
    }

    public void setPlayer(List<Player> player) {
        this.player = player;
    }

    public static class Builder{

        int dimensions;

        List<Player> player;

        public Builder(){

        }

        public Builder(int dimensions, List<Player> player) {
            this.dimensions = dimensions;
            this.player = player;
        }


        public int getDimensions() {
            return dimensions;
        }

        public Builder setDimensions(int dimensions) {
            this.dimensions = dimensions;
            return this;
        }

        public List<Player> getPlayer() {
            return player;
        }

        public Builder setPlayer(List<Player> player) {
            this.player = player;
            return this;
        }

        private void isValid() throws InvalidGameBuildException {

            if(this.dimensions < 3){
                throw new InvalidGameBuildException("Dimensions is less than 3");
            }

            if(player.size() != this.dimensions - 1){
                throw new InvalidGameBuildException("Issue with player");
            }

        }

        public Game Build() throws InvalidGameBuildException {
            isValid();

            Game game = new Game();
            game.setBoard(new Board(dimensions));
            game.setPlayer(player);
            game.setStatus(GameStatus.IN_PROGRESS);
            game.setMove(new ArrayList<>());
            game.setNextPlayerIndex(0);

            return game;
        }
    }
}
