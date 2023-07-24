package factory;

import modals.BotDifficulty;
import strategy.BotPlayingStartgey.BotPlayingStratgey;
import strategy.BotPlayingStartgey.RandomBotPlayingStratgey;

public class BotPlayingStrategyFactory {

    public BotPlayingStratgey botPlayingStratgey(BotDifficulty botDifficulty){

        if(botDifficulty.equals(BotDifficulty.EASY)){
            return new RandomBotPlayingStratgey();
        }
        return null;
    }
}
