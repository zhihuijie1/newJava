package tank;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        TankFrame tankFrame = new TankFrame();
        while(true) {
            Thread.sleep(20);
            tankFrame.repaint();
        }
    }
}
