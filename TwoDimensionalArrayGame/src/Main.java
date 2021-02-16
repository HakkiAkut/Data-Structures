/**
 * @author Hakkı Can Akut
 */

import java.io.File;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        runGame();
    }


    public static void runGame() {
        // in start of every turn clears every file in all_turn directory,
        // in all_turn directory, every turns info will be separately added.
        // also every turn info will be added in one results.txt file,
        File dir = new File("all_turns/");
        for(File files: dir.listFiles()){
            files.delete();
        }

        Game game = new Game(); // initialize game
        game.resetResultFile();// resets result.txt file, so there won't be any data from previous games.
        game.setGameMap(); // sets game map
        game.setObstacles(); // adds obstacles to map
        game.setFinishPoint(); // adds finish point to map
        game.setPlayers(); // adds players to map
        game.getNumberOfPlayer(); // gets number of player for every tile, with this we know number of players for every tile(tile has numberOfPlayers attribute)
        boolean run = true;// if game ends run will false and while loop will be closed
        boolean printTurn = true; //if print turn false it would only shows last state
        boolean check = true; // check users choice, if this false game will continue automatically
        String choice;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Game starts!");
        game.writeResultToFile("Game starts!\n");
        System.out.println("Note: x shows horizontal location and starts from 0, and y shows vertical location");
        game.writeResultToFile("Note: x shows horizontal location and starts from 0, and y shows vertical location\n");
        System.out.println("Note: f shows finish point, x shows obstacle, numbers shows how much player is in that tile, for 10 or more * will used instead of numbers");
        game.writeResultToFile("Note: f shows finish point, x shows obstacle, numbers shows how much player is in that tile, for 10 or more * will used instead of numbers\n");
        System.out.println("\n\n------------------------------------");
        game.writeResultToFile("\n\n------------------------------------\n");

        while (run) {
            if (printTurn || game.turn == 0) {
                System.out.println("turn: " + game.turn);
                game.writeResultToFile("turn: " + game.turn + "\n");
                game.printMap();
                game.printPlayersLocation();
                System.out.println("------------------------------------");
                game.writeResultToFile("------------------------------------\n");
            }
            if (check) {
                System.out.println("press enter for next turn, r + enter for full run, l + enter for only finished last state");
                game.writeResultToFile("press enter for next turn, r + enter for full run, l + enter for only finished last state\n");
                choice = scanner.nextLine();
                switch (choice) {
                    case "r":
                        check = false;
                        game.writeResultToFile("// user input: r\n");
                        break;
                    case "l":
                        printTurn = false;
                        game.writeResultToFile("// user input: l\n");
                        check = false;
                        break;
                    default:
                        // next turn
                        game.writeResultToFile("// user input: enter\n");
                        break;
                }
            }
            game.movePlayers();
            game.addTurn();
            if (game.isGameEnded(true)) {
                run = false;
            }
        }
        System.out.println("\n__________ game is finished! ___________");
        game.writeResultToFile("\n__________ game is finished! ___________\n");
        System.out.println("\nlast turn is " + (game.turn - 1));
        game.writeResultToFile("\nlast turn is " + (game.turn - 1) + "\n");
        game.printMap();
        game.printPlayersLocation();
    }
}
