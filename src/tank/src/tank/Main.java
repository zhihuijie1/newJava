package tank;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        TankFrame tankFrame = new TankFrame();
        int w = 20;
        int h = 100;
        for (int i = 0; i < 5; i++) {
            tankFrame.tanks.add(new Tank(w, h, Dir.DOWN, tankFrame));
            w += 50;
        }
        while (true) {
            Thread.sleep(20);
            tankFrame.repaint();
        }
    }
}
