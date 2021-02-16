public class Tile {
    private Position position;
    private int numberOfPlayers=0;
    private boolean obstacle;
    private boolean finishPoint;

    public Tile(Position position) {
        this.position = position;
        this.obstacle = false;
        this.finishPoint=false;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers() {
        this.numberOfPlayers += 1;
    }
    public void setNumberOfPlayers(int i) {
        this.numberOfPlayers = i;
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
