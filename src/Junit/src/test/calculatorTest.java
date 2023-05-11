package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p1.calculator;

public class calculatorTest {

    @Before
    public void printMethod1() {
        System.out.println("please start the Test");
    }

    @After
    public void printMethod2() {
        System.out.println("please END the Test");
    }

    @Test
    public void addTest() {
        int result = new calculator().add(10, 20);
        System.out.println("测试加法");
        //System.out.println(result);
        //加入断言：预测一下结果，判断一下我预测的结果和 实际的结果是否一致：
        Assert.assertEquals(30, result);
        //第一个参数：预测结果  第二个参数：实际结果
    }

    @Test
    public void subTest() {
        System.out.println("测试减法");
        int result = new calculator().sub(10, 20);
        //System.out.println(result);
        Assert.assertEquals(-10, result);
    }
}
