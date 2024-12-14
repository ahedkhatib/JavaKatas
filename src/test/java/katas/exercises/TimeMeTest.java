package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TimeMeTest {

    @Test
    public void testTimeMe(){
        Runnable sampleFunction = () -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        long timeTaken = TimeMe.measureExecutionTime(sampleFunction);
        assertTrue(timeTaken >= 500);
    }

    @Test
    public void testQuickTimeMe(){
        Runnable quickFunction = () -> System.out.println("Quick task done!");
        long timeTaken = TimeMe.measureExecutionTime(quickFunction);

        assertTrue(timeTaken >= 0);
    }

    @Test
    public void testNothingTimeMe(){
        Runnable quickFunction = () -> {};
        long timeTaken = TimeMe.measureExecutionTime(quickFunction);

        assertTrue(timeTaken >= 0);
    }

    @Test
    public void testShortTimeMe(){
        Runnable sampleFunction = () -> {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        long timeTaken = TimeMe.measureExecutionTime(sampleFunction);
        assertTrue(timeTaken >= 50);
    }
}
