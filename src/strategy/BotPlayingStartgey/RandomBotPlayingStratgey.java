package strategy.BotPlayingStartgey;

import modals.*;

public class RandomBotPlayingStratgey implements BotPlayingStratgey {


    @Override
    public Move makeMove(Player bot, Board board) {



        for(int i = 0; i < board.getBoard().size(); i++){
            for (int j = 0; j < board.getBoard().get(i).size(); j++){

                if(board.getBoard().get(i).get(j).getState().equals(CellState.EMPTY)){
                    return new Move(bot, new Cell(i, j,bot, CellState.FILLED));
                }
            }
        }


        return null;
    }
}
