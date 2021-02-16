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


    // player randomly moves, if statements check is user in border or in the edge of map,
    // obstacles are get checked in movePlayers() method in Game class, finish point is checked in isGameEnded() method in Game Class
    public void move() {
        Random rand = new Random();
        int choice;
        if (p.getX() == 0 && p.getY() == 0) {
            choice = rand.nextInt(2);
            switch (choice) {
                case 0:
                    p.addX();
                    break;
                case 1:
                    p.addY();
                    break;

            }
        } else if (p.getX() == 0 && p.getY() == (var.height - 1)) {
            choice = rand.nextInt(2);
            switch (choice) {
                case 0:
                    p.addX();
                    break;
                case 1:
                    p.subY();
                    break;
            }
        } else if (p.getX() == 0) {
            choice = rand.nextInt(3);
            switch (choice) {
                case 0:
                    p.addX();
                    break;
                case 1:
                    p.addY();
                    break;
                case 2:
                    p.subY();
                    break;
            }
        } else if (p.getY() == 0 && p.getX() == (var.width - 1)) {
            choice = rand.nextInt(2);
            switch (choice) {
                case 0:
                    p.subX();
                    break;
                case 1:
                    p.addY();
                    break;
            }
        } else if (p.getY() == 0) {
            choice = rand.nextInt(3);
            switch (choice) {
                case 0:
                    p.addX();
                    break;
                case 1:
                    p.addY();
                    break;
                case 2:
                    p.subX();
                    break;
            }
        } else if (p.getX() == (var.width - 1) && p.getY() == (var.height - 1)) {
            choice = rand.nextInt(2);
            switch (choice) {
                case 0:
                    p.subX();
                    break;
                case 1:
                    p.subY();
                    break;
            }
        } else if (p.getX() == (var.width - 1)) {
            choice = rand.nextInt(3);
            switch (choice) {
                case 0:
                    p.subY();
                    break;
                case 1:
                    p.addY();
                    break;
                case 2:
                    p.subX();
                    break;
            }
        } else if (p.getY() == (var.height - 1)) {
            choice = rand.nextInt(3);
            switch (choice) {
                case 0:
                    p.subX();
                    break;
                case 1:
                    p.addX();
                    break;
                case 2:
                    p.subY();
                    break;
            }
        } else {
            choice = rand.nextInt(4);
            switch (choice) {
                case 0:
                    p.subX();
                    break;
                case 1:
                    p.addX();
                    break;
                case 2:
                    p.subY();
                    break;
                case 3:
                    p.addY();
                    break;
            }
        }
    }
}
