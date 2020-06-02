package ObjectsGame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class NormalTower extends Tower {
    ArrayList<Bullet> bullets = new ArrayList<>();
    long start = System.currentTimeMillis();
    Image imageNormalTowerLevel2 = new ImageIcon(getClass().getResource("/Defaultsize/" + "NormalTowerLevel2"+".png")).getImage();
    Image imageNormalTowerLevel3 = new ImageIcon(getClass().getResource("/Defaultsize/" + "NormalTowerLevel3"+".png")).getImage();

    public NormalTower(int x, int y) {
        this.x = x;
        this.y = y;
        this.base = new ImageIcon(getClass().getResource("/Defaultsize/towerDefense_tile" + "180" + ".png")).getImage();
        this.img = new ImageIcon(getClass().getResource("/Defaultsize/towerDefense_tile" + "249" + ".png")).getImage();
        this.dame = 1;
        this.SpeedGun = 10;
        this.shootRange = 100;
        this.price = 20;
    }

    @Override
    public void update() {
        if(this.level ==1){
            this.level = 2 ;
            this.dame +=1;
            this.shootRange +=10;
            this.img = imageNormalTowerLevel2;
        }
        else if(this.level == 2){
            this.dame +=1;
            this.shootRange +=10;
            this.level = 3;
            this.img = imageNormalTowerLevel3;
        }
    }

    @Override
    public void shoot(Enemy e) {
        long end = System.currentTimeMillis();
        if((end-start)/300 > 1){
            start = System.currentTimeMillis();
            Point a = new Point((int) e.x + 40 - (int) (this.x + 32), -((int) e.y + 20 - (int) (this.y + 32)));
            if (e.direction == Direction.UP) {
                a = new Point((int) e.x + 40 - (int) (this.x + 32), -((int) e.y + 20  - (int) (this.y + 32)));
            }
            else if (e.direction == Direction.RIGHT) {
                a = new Point((int) e.x + 44 - (int) (this.x + 32), -((int) e.y + 40 - (int) (this.y + 32)));
            }
            else if (e.direction == Direction.DOWN) {
                a = new Point((int) e.x + 32 - (int) (this.x + 32), -((int) e.y + 40 - (int) (this.y + 32)));
            }
            bullets.add(new BulletFire((int)x,(int)y,a, radian));
        }
        for(Bullet bullet : bullets){
            if(e.intersects(bullet)){
                if (e.health <= 0) {
                    e.invisible = false;

                }
                e.health -=this.dame;
                bullet.Invisible = false;
            }
        }
    }
    @Override
    public void render(Graphics2D graphics2D){
        super.render(graphics2D);
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
