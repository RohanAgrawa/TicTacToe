package modals;

public class Player {

    private String playerName;

    private PlayerType type;

    private char symbol;


    public Player(String playerName, PlayerType type, char symbol) {
        this.playerName = playerName;
        this.type = type;
        this.symbol = symbol;
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
