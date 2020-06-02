package ObjectsGame;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class BossEnemy extends Enemy {
    public BossEnemy(int x, int y) {
        this.x = x;
        this.y = y;
        this.speed = 1;
        this.health = 500;
        this.armor = this.health;
        this.reward = 50;
        this.img = new ImageIcon(getClass().getResource("/Defaultsize/BossTank.png")).getImage();
        this.direction = Direction.UP;
    }


    @Override
    public void render(Graphics2D g2d) {
        int i =(int) x;
        int j = (int) y;

        updateDirection();

        AffineTransform backup = g2d.getTransform();

        if (direction != Direction.LEFT) {
            g2d.setColor(Color.RED);
            g2d.setBackground(Color.RED);
            g2d.draw(new Rectangle(i+10,j -10,40,5));
            g2d.fill(new Rectangle(i+10,j -10,(int)(this.health*1.0/this.armor*40),5));
            g2d.setColor(Color.BLACK);
        }

        if (direction == Direction.UP) {
            update();
            AffineTransform a = AffineTransform.getRotateInstance(-Math.PI / 2, i + 32, j + 32);
            g2d.setTransform(a);
            g2d.drawImage(img, i, j, null);
            setBounds(i + 16, j + 21, 32, 22);
        }
        else if (direction == Direction.RIGHT) {
            update();
            AffineTransform a = AffineTransform.getRotateInstance(0 , i + 32, j + 32);
            g2d.setTransform(a);
            g2d.drawImage(img, i, j, null);
            setBounds(i + 21, j + 16, 22, 32);
        }
        else if (direction == Direction.DOWN) {
            update();
            AffineTransform a = AffineTransform.getRotateInstance( Math.PI/2, i + 32, j + 32);
            g2d.setTransform(a);
            g2d.drawImage(img, i, j, null);
            setBounds(i + 16, j + 21, 32, 22);
        }
        g2d.setTransform(backup);
    }
}
