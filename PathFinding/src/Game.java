import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Game {
    Player player;
    Tile[][] gameMap;
    Var var;

    /**
     * constructor method
     */
    public Game() {
        var = new Var();
        gameMap = new Tile[var.height][var.width];
        setGameMap();
        setObstacles();
        setFinishPoint();
        setPlayer();
    }

    /**
     * sets map tiles
     */
    public void setGameMap() {
        for (int i = 0; i < gameMap.length; i++) {
            for (int j = 0; j < gameMap[0].length; j++) {
                gameMap[i][j] = new Tile(new Position(j, i));
            }
        }
    }

    /**
     * adds obstacles
     */
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

    /**
     * adds finish point
     */
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

    /**
     * adds player
     */
    public void setPlayer() {
        Random random = new Random();
        int x = 0;
        int y = 0;
        do {
            y = random.nextInt(gameMap.length);
            x = random.nextInt(gameMap[0].length);
        } while (gameMap[y][x].isObstacle() || gameMap[y][x].isFinishPoint());
        player = new Player(new Position(x, y));
        gameMap[y][x].setPlayer(true);
    }

    /**
     * prints map and also writes in result file
     */
    public void printMap() {
        System.out.println("f is finish point, x is obstacle, p is player");
        writeResultToFile("f is finish point, x is obstacle, p is player\n");
        for (int i = 0; i < gameMap.length; i++) {
            System.out.println("");
            writeResultToFile("\n");
            for (int j = 0; j < gameMap[0].length; j++) {
                // prints finish point as f
                if (gameMap[i][j].isFinishPoint()) {
                    System.out.print("f");
                    writeResultToFile("f");
                    // prints obstacle as x
                } else if (gameMap[i][j].isObstacle()) {
                    System.out.print("x");
                    writeResultToFile("x");
                } else {
                    // prints player as p
                    if (gameMap[i][j].isPlayer()) {
                        System.out.print("p");
                        writeResultToFile("p");
                    } // 0 for empty tiles
                    else {
                        System.out.print("0");
                        writeResultToFile("0");
                    }
                }
            }
        }
        System.out.println("");
        writeResultToFile("\n");
    }

    /**
     * writes string to the result file
      */
    public void writeResultToFile(String str) {
        try {
            FileWriter fileWriter = new FileWriter("result.txt", true);
            fileWriter.write(str);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }

    /**
     * reset files, when games starts so only recent game data will be there
     */
    public void resetResultFile() {
        try {
            FileWriter fileWriter = new FileWriter("result.txt");
            fileWriter.write("");
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }
}
