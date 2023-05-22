package tank;

import java.awt.*;

public class Tank {
    /**
     * 属性
     */
    int x;
    int y;

    public int tankWedth = ResourceMgr.tankD.getWidth();
    public int tankHeight = ResourceMgr.tankD.getHeight();

    TankFrame tf;
    Dir dir; //记录着方向。
    private static final int speed = 10;//记录坦克的速度

    private boolean moving = false;
    private boolean living;

    /**
     * 构造器
     */
    public Tank(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
        this.living = true;
    }

    /**
     * 方法
     */
    public void paint(Graphics g) {
        //g.fillRect(x, y, 50, 50);//画一个小矩形
        if (!living) {
            tf.tanks.remove(this);
        }
        switch (dir) {
            case LEFT -> {
                g.drawImage(ResourceMgr.tankL, this.x, this.y, null);
                break;
            }
            case RIGHT -> {
                g.drawImage(ResourceMgr.tankR, this.x, this.y, null);
                break;
            }
            case UP -> {
                g.drawImage(ResourceMgr.tankU, this.x, this.y, null);
                break;
            }
            case DOWN -> {
                g.drawImage(ResourceMgr.tankD, this.x, this.y, null);
                break;
            }
        }
        if (this.moving) {
            move();
        }
    }

    private void move() {
        switch (dir) {
            case UP -> {
                y -= speed;
                break;
            }
            case DOWN -> {
                y += speed;
                break;
            }
            case LEFT -> {
                x -= speed;
                break;
            }
            case RIGHT -> {
                x += speed;
                break;
            }
        }
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void fire() {
        int x = this.x + (tankWedth / 2) - (Bullet.bulletWidth / 2);
        int y = this.y + (tankHeight / 2) - (Bullet.bulletHeight / 2);
        tf.bullets.add(new Bullet(x, y, this.dir, tf));
    }

    public void die() {
        this.living = false;
    }
}
