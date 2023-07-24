package modals;
import factory.BotPlayingStrategyFactory;
import strategy.BotPlayingStartgey.BotPlayingStratgey;

public class Bot extends Player{

    private BotDifficulty botDifficulty;
    private BotPlayingStratgey botPlayingStratgey;

    public Bot(String playerName, char symbol, BotDifficulty botDifficulty)
    {
        super(playerName, PlayerType.BOT, symbol);
        this.botDifficulty = botDifficulty;
        BotPlayingStrategyFactory botPlayingStrategyFactory = new BotPlayingStrategyFactory();
        this.botPlayingStratgey = botPlayingStrategyFactory.botPlayingStratgey(this.botDifficulty);
    }

    public BotDifficulty getBotDifficulty() {
        return botDifficulty;
    }

    public void setBotDifficulty(BotDifficulty botDifficulty) {
        this.botDifficulty = botDifficulty;
    }

    public Move decideMove(Board board){

        return botPlayingStratgey.makeMove(this, board);
    }
}
