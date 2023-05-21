package tank;

import java.awt.*;
import java.util.Collections;

public class Bullet {
    private int x;
    private int y;
    private int width = 30;
    private int height = 30;
    private static final int SPEED = 10;
    private Dir dir;

    public Bullet(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(x, y, width, height);
        g.setColor(c);
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
    }
}
