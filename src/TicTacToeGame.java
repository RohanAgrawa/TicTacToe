import Controller.GameController;
import modals.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Dimensions of the game");

        int dimensions = sc.nextInt();

        sc.nextLine();

        System.out.println("Is their any bot in the game ? (Y/N)");

        String isBot = sc.nextLine();

        int noHumanPlayers = dimensions - 1;

        List<Player> player = new ArrayList<>();

        if(isBot.equals("Y")){
            noHumanPlayers -= 1;

            System.out.println("What is the name of Bot ?");

            String botName = sc.nextLine();

            System.out.println("What is the symbol of Bot :");

            String symbol = sc.nextLine();

            player.add(new Bot(botName, symbol.charAt(0), BotDifficulty.EASY));
        }

        for(int i = 0; i < noHumanPlayers; i++){

            System.out.println("What is the name of the Player : " + (i + 1));

            String playerName = sc.nextLine();

            System.out.println("What is the Symbol of : " + (i + 1) + "Player");

            String playerSymbol = sc.nextLine();

            player.add(new Player(playerName, PlayerType.HUMAN, playerSymbol.charAt(0)));
        }

        GameController gameController = new GameController();

        Game game = gameController.createGame(dimensions, player);

        // Players will start the game

        while(game.getStatus().equals(GameStatus.IN_PROGRESS)){

            System.out.println("This is the current Board");

            gameController.displayBoard(game);

            System.out.println("Do you want to undo : (y/n)");

            String undo = sc.nextLine();

            if(undo.equals("y")){
                gameController.undo(game);
            }
            else{
                gameController.executeNextMove(game);
            }


        }

        // Some one has won the game or game became draw

        if(game.getStatus().equals(GameStatus.ENDED)){
            if(gameController.getWinner(game) != null){
            System.out.println("Winner of the game is " + gameController.getWinner(game).getPlayerName());}
            else {
                System.out.println("Game is Draw nobody is winner");
            }
        }
    }
}
