package knightsoul.SpaceKittens;

public class Bomb {

    private int dx;
    private int dy;
    private int direction;

    public void Bomb(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public int getDirection() {
        return this.direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getDx() {
        return this.dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return this.dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }
}
