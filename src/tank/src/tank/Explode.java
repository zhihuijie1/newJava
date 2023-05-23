package tank;

import java.awt.*;

public class Explode {
    public static int Width = ResourceMgr.explodes[0].getWidth();
    public static int Height = ResourceMgr.explodes[0].getHeight();

    private int x, y;
    private boolean living = true;
    TankFrame tf = null;
    private int step = 0;

    public Explode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
        new Audio("audio/explode.wav").play();
    }

    public void paint(Graphics g) {
        if(step >= ResourceMgr.explodes.length){
            step = 0;
        }else {
            g.drawImage(ResourceMgr.explodes[step], this.x, this.y, null);
            step++;
        }
    }
}
