package tank;

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static junit.framework.TestCase.assertNotNull;

public class ImageTest {
    @Test
    public void Test() throws IOException {
        //通过类加载器将这个图片加载成一个输入流。
        InputStream inputStream = ImageTest.class.getClassLoader().getResourceAsStream("images/4.gif");
        //将这个输入流转化成图片。
        BufferedImage image = ImageIO.read(inputStream);
        assertNotNull(image);
    }
}
