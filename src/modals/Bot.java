package modals;
import java.util.List;
public class Bot extends Player{

    private BotDifficulty botDifficulty;

    public Bot(String playerName, char symbol, BotDifficulty botDifficulty)
    {
        super(playerName, PlayerType.BOT, symbol);
        this.botDifficulty = botDifficulty;
    }

    public BotDifficulty getBotDifficulty() {
        return botDifficulty;
    }

    public void setBotDifficulty(BotDifficulty botDifficulty) {
        this.botDifficulty = botDifficulty;
    }
}
