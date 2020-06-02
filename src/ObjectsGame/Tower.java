package ObjectsGame;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

public abstract class Tower extends GameEntity {
    ArrayList<Bullet>bullets = new ArrayList<>();

    public int level = 1;
    public int price;

    public void setLevel(int level) {
        this.level = level;
    }

    protected double dame;

    public int getLevel() {
        return level;
    }

    protected double SpeedGun;
    protected double shootRange;
    protected Image base;
    public double radian = 0;

    public double getDame() {
        return dame;
    }

    public double getSpeedGun() {
        return SpeedGun;
    }

    public double getShootRange() {
        return shootRange;
    }

    public double getRadian() {return  (radian/Math.PI) * 180;}

    public void setRadian(Enemy e) {
        Point a = new Point((int) e.x + 40 - (int) (this.x + 32), (int) e.y + 20 - (int) (this.y + 32));;
        if (e.direction == Direction.UP) {
            a = new Point((int) e.x + 40 - (int) (this.x + 32), (int) e.y + 20  - (int) (this.y + 32));
        }
        else if (e.direction == Direction.RIGHT) {
            a = new Point((int) e.x + 44 - (int) (this.x + 32), (int) e.y + 40 - (int) (this.y + 32));
        }
        else if (e.direction == Direction.DOWN) {
            a = new Point((int) e.x + 32 - (int) (this.x + 32), (int) e.y + 40 - (int) (this.y + 32));
        }
        Point b = new Point(0, -1);
        if (a.x < 0) {
            radian = -Math.acos((a.x*b.x + a.y*b.y)/(Math.sqrt(a.x*a.x + a.y*a.y) + Math.sqrt(b.x*b.x + b.y*b.y)));
        }
        else {
            radian = Math.acos((a.x*b.x + a.y*b.y)/(Math.sqrt(a.x*a.x + a.y*a.y) + Math.sqrt(b.x*b.x + b.y*b.y)));
        }
    }

    public  abstract  void shoot(Enemy e);

    @Override
    public void render(Graphics2D graphics2D) {
        int i =(int) x;
        int j = (int) y;
        int shot = (int) shootRange + 20;

        setBounds(i+32-shot, j+32-shot, shot*2, shot*2);

        graphics2D.drawImage(base, i, j, null);

        AffineTransform backup = graphics2D.getTransform();
        AffineTransform a = AffineTransform.getRotateInstance(radian , i+32, j+32);
        graphics2D.setTransform(a);

        graphics2D.drawImage(img, i, j, null);

        graphics2D.setTransform(backup);
        renderBullet(graphics2D);
    }

    public void renderBullet(Graphics2D graphics2D) {
        for(int a = 0 ; a < bullets.size() ; a++){
            if(bullets.get(a).Invisible){
                if(Math.abs(bullets.get(a).x - this.x) > shootRange )
                    bullets.get(a).Invisible = false;
                bullets.get(a).render(graphics2D);
            }else{
                bullets.remove(a);
            }
        }
    }
}
