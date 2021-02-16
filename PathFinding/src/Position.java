public class Position {
    private int x=0;
    private int y=0;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void addX() {
        this.x++;
    }

    public void addY() {
        this.y++;
    }

    public void subX() {
        this.x--;
    }

    public void subY() {
        this.y--;
    }

}
