package com.batiaev.java3.lesson6;

import lombok.extern.java.Log;
import org.junit.*;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@Log
@RunWith(CustomRunner.class)
public class CalculatorTest {
    private Calculator calculator;

    @BeforeClass
    public static void baseSetUp() throws Exception {
        System.out.println("before preparation");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("prepare");
        calculator = new Calculator();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("cleanUp");
    }

    @AfterClass
    public static void tearDownLast() {
        System.out.println("cleanUp after all");
    }

    @Test
    public void add() {
        System.out.println("sum");
        int sum = calculator.add(5, 6);
        assertEquals("Invalid sum", 11, sum);
    }

    @Test
    public void sub() {
        System.out.println("sub");
        int result = calculator.sub(5, 6);
        assertEquals(result, -1);
    }

    @Test
    @Ignore("important reason")
    public void mul() {
    }

    @Test(timeout = 300)
    public void div() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}