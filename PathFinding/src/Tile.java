public class Tile {
    private Position position;
    private boolean player;
    private boolean obstacle;
    private boolean finishPoint;

    public Tile(Position position) {
        this.position = position;
        this.player = false;
        this.obstacle = false;
        this.finishPoint = false;
    }

    public boolean isPlayer() {
        return player;
    }


    public void setPlayer(boolean player) {
    // if it's finish point it won't turn to true because for other recursion calls it has to be movable
        if(!finishPoint){
            this.player = player;
        }
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public boolean isObstacle() {
        return obstacle;
    }

    public void setObstacle(boolean obstacle) {
        this.obstacle = obstacle;
    }

    public boolean isFinishPoint() {
        return finishPoint;
    }

    public void setFinishPoint(boolean finishPoint) {
        this.finishPoint = finishPoint;
    }
}
