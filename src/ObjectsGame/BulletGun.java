package ObjectsGame;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class BulletGun extends Bullet {
    boolean Invisible = true;
    double Radian;
    Point A;
    Point B;
    public BulletGun(int x, int y, Point A, double radian){
        super(x,y,A);
        this.Radian = radian;
        this.x = x ;
        this.y = y ;
        this.img =  new ImageIcon(getClass().getResource("/Defaultsize/towerDefense_tile" + "272" + ".png")).getImage();
        this.A = A;
        this.B = new Point(x,y);
    }
    @Override
    public void update() {
        if(A.x > 0) {
            x = x + Math.abs((int) 9*Math.sin(Radian));
        }else {
            x = x - Math.abs((int) 9*Math.sin(Radian));
        }
        y =B.y-(((x-B.x)*A.y)/A.x);
    }

    @Override
    public void render(Graphics2D g2d) {
        update();
        int  i =(int) (x);
        int  j =(int) (y);
        setBounds(i+32,j+32,1,1);
        g2d.drawImage(img,i,j,null);

    }
}