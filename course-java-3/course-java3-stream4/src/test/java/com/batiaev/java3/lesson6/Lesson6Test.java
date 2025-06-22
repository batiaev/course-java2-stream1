package com.batiaev.java3.lesson6;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.*;

import java.lang.annotation.Documented;

import static org.junit.Assert.*;

/**
 * Lesson6Test
 *
 * @author anton
 * @since 05/09/19
 */
@Data
@Deprecated
public class Lesson6Test {


    @Deprecated private Lesson6 lesson6 ;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("beforeClass");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("setUp");
        lesson6 = new Lesson6();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("tearDown");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("afterClass");
    }

    @Test(timeout = 1000)
    public void sum() {
        final long sum = lesson6.sum(2, 3);
        double sum2 = sum;
        assertNotNull(lesson6);
        Assert.assertEquals(5, sum);
        Assert.assertEquals(5.0, sum2, 0.001);
        assertTrue(sum > 0);
        System.out.println("sum");
    }

    @Test(expected = ArithmeticException.class)
    public void divide() {
        final double divide = lesson6.divide(2, 0);
    }

    @Test
    public void sum2() {
        System.out.println("sum2");
    }
}