import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Game {
    Player[] players;
    Tile[][] gameMap;
    Var var;
    int turn;

    // constructor method
    public Game() {
        var = new Var();
        players = new Player[var.numberOfPeople];
        gameMap = new Tile[var.height][var.width];
        turn = 0;
    }

    // sets map tiles
    public void setGameMap() {
        for (int i = 0; i < gameMap.length; i++) {
            for (int j = 0; j < gameMap[0].length; j++) {
                gameMap[i][j] = new Tile(new Position(j, i));
            }
        }
    }

    // adds obstacles
    public void setObstacles() {
        Random random = new Random();
        for (int i = 0; i < var.numberOfObstacle; i++) {
            int y = random.nextInt(gameMap.length);
            int x = random.nextInt(gameMap[0].length);
            if (gameMap[y][x].isObstacle()) {
                i--;
            } else {
                gameMap[y][x].setObstacle(true);
            }
        }
    }

    // adds finish point
    public void setFinishPoint() {
        Random random = new Random();
        boolean isDone = true;
        while (isDone) {
            int y = random.nextInt(gameMap.length);
            int x = random.nextInt(gameMap[0].length);
            if (!gameMap[y][x].isObstacle()) {
                gameMap[y][x].setFinishPoint(true);
                isDone = false;
            }
        }
    }

    // create players in free tiles
    public void setPlayers() {
        Random random = new Random();
        for (int i = 0; i < players.length; i++) {
            int y = random.nextInt(gameMap.length);
            int x = random.nextInt(gameMap[0].length);
            if (gameMap[y][x].isObstacle() || gameMap[y][x].isFinishPoint()) {
                i--;
            } else {
                players[i] = new Player(new Position(x, y));
                //gameMap[y][x].setObstacle(true);
            }
        }
    }

    // updates number of user for each tile
    public void getNumberOfPlayer() {
        for (int i = 0; i < players.length; i++) {
            gameMap[players[i].getPosition().getY()][players[i].getPosition().getX()].setNumberOfPlayers();
        }
    }

    // clears number of user for each tile
    public void clearPlayers() {
        for (int i = 0; i < gameMap.length; i++) {
            for (int j = 0; j < gameMap[0].length; j++) {
                gameMap[i][j].setNumberOfPlayers(0);
            }
        }
    }

    // prints map and also writes in result file
    public void printMap() {
        for (int i = 0; i < gameMap.length; i++) {
            System.out.println("");
            writeResultToFile("\n");
            writeResultToTurnFile("\n");
            for (int j = 0; j < gameMap[0].length; j++) {
                // prints finish point as f
                if (gameMap[i][j].isFinishPoint()) {
                    System.out.print("f");
                    writeResultToFile("f");
                    writeResultToTurnFile("f");
                    // prints obstacle as x
                } else if (gameMap[i][j].isObstacle()) {
                    System.out.print("x");
                    writeResultToFile("x");
                    writeResultToTurnFile("x");
                } else {
                    // prints number of player in tile like 1 or 3
                    if (gameMap[i][j].getNumberOfPlayers() < 10) {
                        System.out.print(gameMap[i][j].getNumberOfPlayers());
                        writeResultToFile(Integer.toString(gameMap[i][j].getNumberOfPlayers()));
                        writeResultToTurnFile(Integer.toString(gameMap[i][j].getNumberOfPlayers()));
                    } // if there is 10 or more player in one tile prints as *
                    else {
                        System.out.print("*");
                        writeResultToFile("*");
                        writeResultToTurnFile("*");
                    }
                }
            }
        }
        System.out.println("");
        writeResultToFile("\n");
        writeResultToTurnFile("\n");
    }

    // prints players location and also writes in result file
    public void printPlayersLocation() {
        for (int i = 0; i < players.length; i++) {
            System.out.println("Player " + i + " Location " + "x: " + players[i].getPosition().getX() + " y: " + players[i].getPosition().getY());
            writeResultToFile("Player " + i + " Location " + "x: " + players[i].getPosition().getX() + " y: " + players[i].getPosition().getY() + "\n");
            writeResultToTurnFile("Player " + i + " Location " + "x: " + players[i].getPosition().getX() + " y: " + players[i].getPosition().getY() + "\n");
        }
    }

    // moves every player, and clears number of player info in tile and rewrites it so, updates information in every tile
    public void movePlayers() {
        for (int i = 0; i < players.length; i++) {
            Position last = new Position(players[i].getPosition().getX(), players[i].getPosition().getY());
            players[i].move();
            // checks is there an obstacle, if there is stays still for that turn
            if (gameMap[players[i].getPosition().getY()][players[i].getPosition().getX()].isObstacle()) {
                players[i].setPosition(last);
            } // checks is the game finished or not
        }
        clearPlayers();
        getNumberOfPlayer();
    }

    // checks is game ended or not
    public boolean isGameEnded(boolean print) {
        for (int i = 0; i < players.length; i++) {
            if (gameMap[players[i].getPosition().getY()][players[i].getPosition().getX()].isFinishPoint()) {
                if(print){
                    System.out.println("player " + i + " is in finish point");
                    writeResultToFile("player " + i + " is in finish point\n");
                }
                return true;
            }
        }
        return false;
    }

    // writes string to the result file
    public void writeResultToFile(String str) {
        try {
            FileWriter fileWriter = new FileWriter("result.txt", true);
            fileWriter.write(str);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }

    // writes string to specific turn file in all_turn directory
    public void writeResultToTurnFile(String str) {
        try {
            if(!isGameEnded(false)){
            FileWriter fileWriter = new FileWriter("all_turns/" + turn + ".txt", true);
                fileWriter.write(str);
                fileWriter.close();
            }

        } catch (IOException e) {
            System.out.println("IOException");
        }
    }

    // reset files, when games starts so only recent game data will be there
    public void resetResultFile() {
        try {
            FileWriter fileWriter = new FileWriter("result.txt");
            fileWriter.write("");
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }

    // adds 1 to turn
    public void addTurn() {
        turn++;
    }
}
