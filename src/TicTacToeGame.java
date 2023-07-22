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

        System.out.println("Hello World");
    }
}
