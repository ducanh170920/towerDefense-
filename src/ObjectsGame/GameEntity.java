package ObjectsGame;

import java.awt.*;

public abstract class GameEntity extends Rectangle {
    protected double x;
    protected double y;
    protected Image img;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    abstract public void update();
    abstract public void render(Graphics2D g2d);
}
