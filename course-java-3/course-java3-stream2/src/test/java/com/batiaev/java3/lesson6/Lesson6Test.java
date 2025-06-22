package com.batiaev.java3.lesson6;

import lombok.extern.slf4j.Slf4j;
import org.junit.*;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@Slf4j
@CustomAnnotation
//@RunWith(Lesson6Test.MyRunner.class)
public class Lesson6Test {

    @Test
    public void main() {
        Lesson6Test lesson6Test = new Lesson6Test();
        CustomAnnotation annotation = lesson6Test.getClass().getAnnotation(CustomAnnotation.class);
        long value = annotation.value();
        System.out.println(value);

    }


    @CustomAnnotation(value = 123)
    private Lesson6 lesson6 = new Lesson6();

    @Before
//    @CustomAnnotation
    public void setUp() throws Exception {
        log.info("setUp");
    }

    @After
    public void tearDown() throws Exception {
        log.info("tearDown");
    }

    @BeforeClass
    public static void before() throws Exception {
        log.info("before");
    }

    @AfterClass
    public static void after() throws Exception {
        log.info("after");
    }

    @Test
    public void sum() {
        long sum = lesson6.sum(4, 5);
        assertEquals(9, sum);
        log.info("run test sum()");
    }

    @Ignore
    @Test(timeout = 100L)
    public void calculateValue() {
//        long timeout = getClass().getMethods()[0].getAnnotation(Test.class).timeout();

        long result = lesson6.calculateValue(9, 5);
        assertEquals(4, result);

        long result2 = lesson6.calculateValue(5, 9);
        assertEquals(-4, result2);
        log.info("run test calculateValue()");
    }

    @Test
    public void sqrt() {
        log.info("run test sqrt()");
    }

    public static class MyRunner extends Runner {
        @Override
        public Description getDescription() {
            return null;
        }

        @Override
        public void run(RunNotifier notifier) {
            Slf4j annotation = getClass().getAnnotation(Slf4j.class);
            annotation.topic();
        }
    }


    @Parameterized.Parameters
    public static List<Object[]> data() {
        return Arrays.asList(new Object[][]{{0, 0}, {1, 1}, {2, 1},
                {3, 2}, {4, 3}, {5, 5}, {6, 8}});
    }

    @Parameterized.Parameter(0)
    public int fInput;

    @Parameterized.Parameter(1)
    public int fExpected;

    @Test
    public void test() {
        assertEquals(fExpected, compute(fInput));
    }

    private int compute(int fInput) {
        return 0;
    }
}