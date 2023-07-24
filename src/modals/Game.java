package modals;

import exceptions.InvalidGameBuildException;
import strategy.GameWiningStartegy.GameWiningStrategy;
import strategy.GameWiningStartegy.orderOneWiningStarategy;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private Board board;

    private List<Player> player;

    private List<Move> moves;

    private int nextPlayerIndex;

    private GameStatus status;

    GameWiningStrategy gameWiningStrategy;

    public GameWiningStrategy getGameWiningStrategy() {
        return gameWiningStrategy;
    }

    public void setGameWiningStrategy(GameWiningStrategy gameWiningStrategy) {
        this.gameWiningStrategy = gameWiningStrategy;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    private Player winner;

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }


    public void makeNextMove(){
        // which player turn is this ?

        Player playerToMove = player.get(nextPlayerIndex);

        System.out.println("It is " + playerToMove.getPlayerName() + "'s turn");

        Move move = playerToMove.decideMove(this.board);

        // Validate the move decided by the player

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        System.out.println("Player is playing a move at (" + row + " " + col + " )");

        // Assumption move is Valid
        board.getBoard().get(row).get(col).setState(CellState.FILLED);
        board.getBoard().get(row).get(col).setPlayer(playerToMove);

        // Adding the current move to the list of Moves

        this.moves.add(move);

        if(this.gameWiningStrategy.checkWinner(this.board, playerToMove, move.getCell())){
            this.setStatus(GameStatus.ENDED);
            winner = playerToMove;
            return;
        }

        // check for Draw

        boolean draw = true;

        for(int i = 0; i < board.getBoard().size(); i++){
            for(int j = 0; j < board.getBoard().get(i).size(); j++){
                if(board.getBoard().get(i).get(j).getState().equals(CellState.EMPTY)){
                    draw = false;
                    break;
                }
            }
        }

        if(draw){
            this.setStatus(GameStatus.ENDED);
            return;
        }

        // Going to next player

        nextPlayerIndex = nextPlayerIndex + 1;
        nextPlayerIndex %= this.player.size();
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
            game.setMoves(new ArrayList<>());
            game.setNextPlayerIndex(0);
            game.setGameWiningStrategy(new orderOneWiningStarategy(dimensions));

            return game;
        }
    }
}
