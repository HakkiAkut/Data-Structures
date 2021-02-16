import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Hakkı Can Akut
 */

public class Main {

    public static void main(String[] args) {
        runGame();
    }


    /**
     * creates Game object, which has game map(tiles, obstacles, finish point) and player
     * after that calls findPath() method.
     */
    public static void runGame() {
        Game game = new Game();
        game.resetResultFile();
        game.printMap();
        findPath(game.player, null, game.gameMap, "");
    }

    /**
     * Basically, method checks player's every possible move which is no tile is revisited for the player from start to finish.
     * Firstly method will add current position to the path string.
     * Secondly method will check is player in finish point (player can't be finish point in starting point) if it is, then will print path and return(method ends)
     * then it will check where player came from so player won't move to this direction(if it comes from right won't move to left)
     * after that method will check is player in left border(is x==0) if it's not then will check is there(left side) any obstacle and was player visit this tile previously
     * if it's not then player will move to left side (x-1) and call findPath() method(recursion) after called method ends,it will reset player position.
     * After that it will do this process for right border(is x==width-1), top border(is y==0) and bottom border(y==height-1) respectively,
     * So it will check every possible moves(with no repetition) and try this paths.
     * After this operations method will end(if it is the child call then it will return to parent basically)
     * So in the end it will check every possible move which is no tile is revisited.
     * @param player is current player
     * @param comeFrom is where player come from
     * @param Map map of the game
     * @param path path string
     * */
    public static void findPath(Player player, String comeFrom, Tile[][] Map, String path) {

        int y = player.getPosition().getY();
        int x = player.getPosition().getX();
        path = path + "(" + x + ", " + y + ") ";

        boolean[] direction = {false, false, false, false};// first top then right bottom and left.

        if (Map[y][x].isFinishPoint()) {
            System.out.println(path);
            printToResultFile(path);
        } else {
            if (comeFrom != null) {
                switch (comeFrom) {
                    case "top":
                        direction[0] = true;
                        break;
                    case "right":
                        direction[1] = true;
                        break;
                    case "bottom":
                        direction[2] = true;
                        break;
                    case "left":
                        direction[3] = true;
                        break;
                }
            }
            // checks is left movable, if it's then it will move left.
            if (x == 0) {
                direction[3] = true;
            } else {
                // if x not in border and player wasn't there previously and there isn't any obstacles player will move.
                if (!Map[y][x - 1].isPlayer() && !Map[y][x - 1].isObstacle() && !direction[3]) {
                    Map[y][x].setPlayer(true);// setting map changes
                    direction[3] = true;
                    player.setPosition(new Position(x - 1, y)); // setting player position
                    findPath(player, "right", Map, path); // calls findPath method (recursion)
                    player.setPosition(new Position(x, y)); // resetting users position
                    Map[y][x].setPlayer(false); // resetting map changes
                }
            }
            // after left side it will check is right side movable
            if (x == (Map[0].length - 1)) {
                direction[1] = true;
            } else {
                if (!Map[y][x + 1].isPlayer() && !Map[y][x + 1].isObstacle() && !direction[1]) {
                    Map[y][x].setPlayer(true);
                    direction[1] = true;
                    player.setPosition(new Position(x + 1, y));
                    findPath(player, "left", Map, path);
                    player.setPosition(new Position(x, y));
                    Map[y][x].setPlayer(false);
                }
            }
            // then it will check top side
            if (y == 0) {
                direction[0] = true;
            } else {
                if (!Map[y - 1][x].isPlayer() && !Map[y - 1][x].isObstacle() && !direction[0]) {
                    Map[y][x].setPlayer(true);
                    direction[0] = true;
                    player.setPosition(new Position(x, y - 1));
                    findPath(player, "bottom", Map, path);
                    player.setPosition(new Position(x, y));
                    Map[y][x].setPlayer(false);
                }
            }
            // then it will check bottom side
            if (y == (Map.length - 1)) {
                direction[2] = true;
            } else {
                if (!Map[y + 1][x].isPlayer() && !Map[y + 1][x].isObstacle() && !direction[2]) {
                    Map[y][x].setPlayer(true);
                    direction[2] = true;
                    player.setPosition(new Position(x, y + 1));
                    findPath(player, "top", Map, path);
                    player.setPosition(new Position(x, y));
                    Map[y][x].setPlayer(false);
                }
            }
        }
    }
    /**
     * writes string to result file
     * */
    public static void printToResultFile(String str){
        try {
            FileWriter fileWriter = new FileWriter("result.txt", true);
            fileWriter.write(str+"\n");
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }
}
