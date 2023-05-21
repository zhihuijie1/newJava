package tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {

    /**
     * 属性
     */
    Tank myTank = new Tank(200, 200, Dir.DOWN);
    Bullet b = new Bullet(300,300,Dir.DOWN);

    /**
     * 构造器
     */
    public TankFrame() throws HeadlessException {
        this.setSize(800, 600);
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
     * 方法
     */

    //paint:绘画方法，系统会自动调用。
    @Override
    public void paint(Graphics g) {//g:是一个画笔，Graphics提供了一些绘画图形的方法。
        myTank.paint(g);
        b.paint(g);
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