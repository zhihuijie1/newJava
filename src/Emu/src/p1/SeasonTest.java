package p1;

import org.junit.Assert;
import org.junit.Test;

public class SeasonTest {
    @Test
    public void test() {
        System.out.println(Season.SPRING.getsName());
        Assert.assertEquals("春天",Season.SPRING.getsName());
    }
}
