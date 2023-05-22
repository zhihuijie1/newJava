package tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TankFrame extends Frame {

    /**
     * @ 属性
     */
    public static final int GAME_WIDTH = 800;
    public static final int GAME_HEIGHT = 600;

    Tank myTank = new Tank(200, 200, Dir.DOWN, this);
    List<Bullet> bullets = new LinkedList<>();
    List<Tank> tanks = new ArrayList<>();

    /**
     * @ 构造器
     */
    public TankFrame() throws HeadlessException {
        this.setSize(GAME_WIDTH, GAME_HEIGHT);
        this.setResizable(false);
        this.setTitle("肝死你们，草泥马");
        // 把这个窗口显示出来
        this.setVisible(true);
        // 点击小叉号关闭窗口
        //addWindowListener:窗口监视器
        this.addKeyListener(new MyKeyListener());
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    /**
     * @ 方法
     */

    // 双缓冲绘制技术，减少可见的闪烁。
    // 总的来说就是先在内存中画完然后再将其一次性显示出来。
    Image offScreenImage = null;//这个图像对象将用于在屏幕之外进行绘制，以避免可见的闪烁效果。

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            //表示第一次进行绘制，因此需要创建一个新的图像对象。通过调用 createImage(width, height) 方法，创建一个与游戏界面大小相匹配的图像对象。
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();//gOffScreen是：offScreenImage中的画笔
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);// 将 "offScreenImage" 绘制到屏幕上，即将之前绘制的内容显示出来。
    }

    //paint:绘画方法，系统会自动调用。
    @Override
    public void paint(Graphics g) {//g:是一个画笔，Graphics提供了一些绘画图形的方法。
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹的数量：" + bullets.size(), 10, 60);
        g.drawString("敌人的数量：" + tanks.size(), 10, 80);
        g.setColor(c);

        myTank.paint(g);

        /*
        涉及到的异常：ConcurrentModificationException
        for (Bullet b : bullets) {
            b.paint(g);
        }
         */

        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).paint(g);
        }

        for (int i = 0; i < tanks.size(); i++) {
            tanks.get(i).paint(g);
        }

        for (int i = 0; i < bullets.size(); i++) {
            for (int j = 0; j < tanks.size(); j++) {
                bullets.get(i).collideWith(tanks.get(j));
            }
        }
    }

    /**
     * @ 内部类  键盘监视器
     */
    class MyKeyListener extends KeyAdapter {

        Boolean bL = false;
        Boolean bR = false;
        Boolean bU = false;
        Boolean bD = false;

        @Override
        public void keyPressed(KeyEvent e) {//一个键被按下时触发
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_LEFT -> {
                    bL = true;
                    break;
                }
                case KeyEvent.VK_RIGHT -> {
                    bR = true;
                    break;
                }
                case KeyEvent.VK_UP -> {
                    bU = true;
                    break;
                }
                case KeyEvent.VK_DOWN -> {
                    bD = true;
                    break;
                }
                case KeyEvent.VK_CONTROL -> {
                    myTank.fire();
                    break;
                }
            }
            setTankDir();
        }

        @Override
        public void keyReleased(KeyEvent e) {//一个键被抬起时触发
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_LEFT -> {
                    bL = false;
                    break;
                }
                case KeyEvent.VK_RIGHT -> {
                    bR = false;
                    break;
                }
                case KeyEvent.VK_UP -> {
                    bU = false;
                    break;
                }
                case KeyEvent.VK_DOWN -> {
                    bD = false;
                    break;
                }
            }
            setTankDir();
        }

        public void setTankDir() {
            if (!bL && !bR && !bD && !bU) {
                myTank.setMoving(false);
            } else {
                myTank.setMoving(true);
                if (bL) myTank.setDir(Dir.LEFT);
                if (bR) myTank.setDir(Dir.RIGHT);
                if (bU) myTank.setDir(Dir.UP);
                if (bD) myTank.setDir(Dir.DOWN);
            }
        }
    }
}