package ObjectsGame;

import java.awt.*;

public abstract class Bullet extends GameEntity {
    boolean Invisible = true;

    Point A;
    Point B;
    public Bullet(int x, int y,Point A){
        this.x = x ;
        this.y = y ;
        this.A = A;
        this.B = new Point(x,y);
    }
    @Override
    public abstract void update();

    @Override
    public abstract void render(Graphics2D g2d) ;

}