package com.batiaev.java3.lesson6;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class Lessons6Test {

//    @Parameterized.Parameters
//    public static List<Object[]> data() {
//        return Arrays.asList(new Object[][]{
//                {0, 0}, {1, 1}, {2, 1},
//                {3, 2}, {4, 3}, {5, 5}, {6, 8}
//        });
//    }
//
//    @Parameterized.Parameter(0)
//    public int fInput;
//
//    @Parameterized.Parameter(1)
//    public int fExpected;


    @Parameterized.Parameter(1)
    private String param1;

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("before class");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("after class");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("before test");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("after test");
    }

    @Test
    public void sum() {
        Lessons6 lessons6 = new Lessons6();
        long sum = lessons6.sum(5, 6);

        assertEquals(11, sum);
        System.out.println("run test 2");
    }

    @Test
    public void secondTestForSum() {
        System.out.println("run test");
    }
}