package tank;

import java.awt.*;

public class Tank {
    /**
     * 属性
     */
    int x;
    int y;
    Dir dir = null; //记录着方向。
    private static final int speed = 10;//记录坦克的速度

    private boolean moving = false;

    /**
     * 构造器
     */
    public Tank(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    /**
     * 方法
     */
    public void paint(Graphics g) {
        g.fillRect(x, y, 50, 50);//画一个小矩形
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
}
