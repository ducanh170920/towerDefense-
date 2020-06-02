package ObjectsGame;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class planesEnemy extends Enemy {

    double radian;

    public planesEnemy(double x) {
        this.x = x;
        this.y = 320*Math.cos(Math.PI/352*this.x) + 320;
        this.speed = 0.4;
        this.health = 10;
        this.armor = health;
        this.reward = 50;
        this.img = new ImageIcon(getClass().getResource("/Defaultsize/towerDefense_tile270.png")).getImage();
        this.imgTank = new ImageIcon(getClass().getResource("/Defaultsize/towerDefense_tile293.png")).getImage();
        this.direction = Direction.UP;
    }

    @Override
    public void setImgTank(Image imgShadow) {
        this.imgTank = imgShadow;
    }
    @Override
    public void setImg(Image img){this.img = img;}

    public void setRadian() {
        double k = -10*Math.PI*Math.sin(Math.PI*this.x/352)/11;
        this.radian = Math.atan(k);
    }

    @Override
    public void update() {
        this.x = this.x + 0.9;
        this.y = 320*Math.cos(Math.PI/352*this.x) + 320;
    }

    @Override
    public void render(Graphics2D graphics2D) {
        int i = (int) x;
        int j = (int) y;
        if (direction != Direction.LEFT) {
            graphics2D.setColor(Color.RED);
            graphics2D.setBackground(Color.RED);
            graphics2D.draw(new Rectangle(i+10,j -10,40,5));
            graphics2D.fill(new Rectangle(i+10,j -10,(int)(this.health*1.0/this.armor*40),5));
            graphics2D.setColor(Color.BLACK);
        }

        update();
        setRadian();

        AffineTransform backup = graphics2D.getTransform();
        AffineTransform a= AffineTransform.getRotateInstance(radian, i - 20 + 32, j + 20 +32);
        graphics2D.setTransform(a);
        graphics2D.drawImage(imgTank, i-20, j+20, null);
        a = AffineTransform.getRotateInstance(radian, i + 32, j + 32);
        graphics2D.setTransform(a);
        graphics2D.drawImage(img, i, j, null);
        setBounds(i+10, j +10, 44,44);
        graphics2D.setTransform(backup);
    }
}
