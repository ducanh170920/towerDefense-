package ObjectsGame;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class Bullet_Rocket extends Bullet {
    double Radian;
    long start=System.currentTimeMillis();
    public Bullet_Rocket(int x, int y, Point A,double radian) {
        super(x, y, A);
        this.img =  new ImageIcon(getClass().getResource("/Defaultsize/towerDefense_tile" + "251" + ".png")).getImage();
        this.Radian = radian;
    }

    @Override
    public void update() {
        if(A.x > 0) {
            x = x + Math.abs((int) 10*Math.sin(Radian));
        }else {
            x = x - Math.abs((int) 10*Math.sin(Radian));
        }
        y =B.y-(((x-B.x)*A.y)/A.x);
    }

    @Override
    public void render(Graphics2D graphics2D) {
        update();
        int  i =(int) (x);
        int  j =(int) (y);
        setBounds(i+32,j+32,1,1);

        AffineTransform backup = graphics2D.getTransform();
        AffineTransform a = AffineTransform.getRotateInstance(Radian , i+32, j+32);
        graphics2D.setTransform(a);

        graphics2D.drawImage(img,i,j,null);
        graphics2D.setTransform(backup);
    }
}
