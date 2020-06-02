package ObjectsGame;

import javax.swing.*;
import java.awt.*;

public class SniperTower extends Tower {
    long start=System.currentTimeMillis();
    Image imageSniperTowerLevel2 =new ImageIcon(getClass().getResource("/Defaultsize/" + "SniperTowerLevel2"+".png")).getImage();
    Image imageSniperTowerLevel3 =new ImageIcon(getClass().getResource("/Defaultsize/" + "SniperTowerLevel3"+".png")).getImage();
    public SniperTower(int x, int y) {
        this.x = x;
        this.y = y;
        this.base = new ImageIcon(getClass().getResource("/Defaultsize/towerDefense_tile" + "181" + ".png")).getImage();;
        this.img = new ImageIcon(getClass().getResource("/Defaultsize/towerDefense_tile" + "250" + ".png")).getImage();
        this.dame = 3;
        this.SpeedGun = 600;
        this.shootRange = 150;
        this.price = 40;
    }

    @Override
    public void update() {
        if(this.level ==1){
            this.level = 2 ;
            this.img = imageSniperTowerLevel2;
            this.dame +=1;
            this.shootRange +=10;
        }
        else if(this.level == 2){
            this.level = 3;
            this.img = imageSniperTowerLevel3;
            this.dame +=1;
            this.shootRange +=10;
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
            bullets.add(new Bullet_Rocket((int)x,(int)y,a, radian));
        }
        for(Bullet bullet : bullets){
            if(e.intersects(bullet)){
                bullet.Invisible = false;
                e.health-=this.dame;
            }
            if(e.health <= 0 ){
                e.invisible = false;
            }
        }
    }
}
