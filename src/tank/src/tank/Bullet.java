package tank;

import java.awt.*;

public class Bullet {
    private int x;
    private int y;
    //private int width = 30;
    //private int height = 30;
    private static final int SPEED = 10;
    private Dir dir;
    private boolean living = true;
    TankFrame tf;

    public static int bulletWidth = ResourceMgr.bulletU.getWidth();
    public static int bulletHeight = ResourceMgr.bulletU.getHeight();

    public Bullet(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
        this.living = true;
    }

    public void paint(Graphics g) {
        if (!living) {
            tf.bullets.remove(this);
        }
            /*
            Color c = g.getColor();
            g.setColor(Color.RED);
            g.fillOval(x, y, width, height);
            g.setColor(c);
             */
        switch (dir) {
            case LEFT -> {
                g.drawImage(ResourceMgr.bulletL, this.x, this.y, null);
                break;
            }
            case RIGHT -> {
                g.drawImage(ResourceMgr.bulletR, this.x, this.y, null);
                break;
            }
            case UP -> {
                g.drawImage(ResourceMgr.bulletU, this.x, this.y, null);
                break;
            }
            case DOWN -> {
                g.drawImage(ResourceMgr.bulletD, this.x, this.y, null);
                break;
            }
        }
        move();

    }

    private void move() {
        switch (dir) {
            case UP -> {
                y -= SPEED;
                break;
            }
            case DOWN -> {
                y += SPEED;
                break;
            }
            case LEFT -> {
                x -= SPEED;
                break;
            }
            case RIGHT -> {
                x += SPEED;
                break;
            }
        }
        living = (x < 0 || x > TankFrame.GAME_WIDTH || y < 0 || y > TankFrame.GAME_HEIGHT) ? false : true;
    }

    public void collideWith(Tank tank) {
        // 当前子弹的矩形
        Rectangle rectangle1 = new Rectangle(this.x, this.y, bulletWidth, bulletHeight);
        // 当前坦克的矩形
        Rectangle rectangle2 = new Rectangle(tank.x, tank.y, tank.tankWedth, tank.tankHeight);
        // 如果两个矩形相交，那么子弹与坦克都消失。
        if (rectangle1.intersects(rectangle2)) {
            this.die();
            tank.die();
        }
    }

    private void die() {
        this.living = false;
    }
}
