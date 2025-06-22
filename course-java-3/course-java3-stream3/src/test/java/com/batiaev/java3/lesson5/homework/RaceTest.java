package com.batiaev.java3.lesson5.homework;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class RaceTest {
    private Race race;

    @Before
    public void setUp() throws Exception {
        race = new Race(new Stage() {
            @Override
            public void go(Car c) {
                assertTrue(c.getSpeed() > 0);
            }
        }, new Road(90));
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getStages() throws Exception {
        List<Stage> stages = race.getStages();
        assertNotNull(stages);
        stages.forEach(stage -> {
            assertNotNull(stage);
            assertTrue(stage.length > 0);
            assertNotNull(stage.getDescription());
        });
    }
}