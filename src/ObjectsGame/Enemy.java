package ObjectsGame;

import java.awt.*;

public abstract class Enemy extends GameEntity {

    protected int health;
    protected double speed;
    protected int armor;
    protected int reward;
    protected Map map;

    public void setReward(int reward) {
        this.reward = reward;
    }

    protected Direction direction;
    public Image imgTank;
    public boolean invisible = true;

    public void setMap(Map map) {
        this.map = map;
    }
    public void setImg(Image img) {
        this.img = img;
    }

    public void setImgTank(Image imgtank) {
        this.imgTank = imgTank;
    }

    public int getReward() {
        return reward;
    }

    public void setHealth(int health) {
        this.health = health;
        this.armor  = health;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void updateDirection() {
        if (map.numberOfMap == 1) {
            if (x == 32 && y > 96) {
                direction = Direction.UP;
            }
            else if (y == 96 && x < 352) {
                direction = Direction.RIGHT;
            }
            else if (x == 352 && y < 416) {
                direction = Direction.DOWN;
            }
            else if (x < 672 && y == 416) {
                direction = Direction.RIGHT;
            }
            else if (x == 672 && y > 160) {
                direction = Direction.UP;
            }
            else if (y == 160 && x <= 960) {
                direction = Direction.RIGHT;
            }
            else if (x > 960) direction = Direction.LEFT;
        }
        else {
            if (x == 32 && y > 352) {
                direction = Direction.UP;
            }
            else if (y == 352 && x < 864) {
                direction = Direction.RIGHT;
            }
            else if (x == 864 && y > 0) {
                direction = Direction.UP;
            }
            else if (y < 0) direction = Direction.LEFT;
        }
    }

    @Override
    public void update() {

        switch (direction) {
            case UP:
                y -= speed;
                break;
            case DOWN:
                y += speed;
                break;
            case LEFT:
                break;
            case RIGHT:
                x += speed;
                break;
        }
    }

    @Override
    public void render(Graphics2D g2d) {}
}
