package modals;

import java.util.Scanner;

public class Player {

    private String playerName;

    private PlayerType type;

    private char symbol;


    public Player(String playerName, PlayerType type, char symbol) {
        this.playerName = playerName;
        this.type = type;
        this.symbol = symbol;
    }

    public Move decideMove(Board board){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter row number for the move : ");
        int row = sc.nextInt();

        System.out.println("Enter column number for the move : ");

        int col = sc.nextInt();

        return new Move(this, new Cell(row, col, this, CellState.FILLED));


    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public PlayerType getType() {
        return type;
    }

    public void setType(PlayerType type) {
        this.type = type;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
}
