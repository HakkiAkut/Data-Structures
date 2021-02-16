import java.util.Random;

public class Player {

    private Position p;
    Var var;

    public Player(Position p) {
        this.p = p;
        var = new Var();
    }

    public Player(Position p, Var var) {
        this.p = p;
        this.var = var;
    }


    public Position getPosition() {
        return p;
    }

    public void setPosition(Position p) {
        this.p = p;
    }


}
