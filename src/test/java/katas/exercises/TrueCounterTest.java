package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrueCounterTest {

    @Test
    public void testValidArray(){
        boolean[] sampleArray = {true, false, true, true, false};
        int trueCount = TrueCounter.countTrueValues(sampleArray);
        assertEquals(3, trueCount);
    }

    @Test
    public void testNullArray(){
        boolean[] sampleArray = null;
        int trueCount = TrueCounter.countTrueValues(sampleArray);
        assertEquals(0, trueCount);
    }

    @Test
    public void testEmptyArray(){
        boolean[] sampleArray = {};
        int trueCount = TrueCounter.countTrueValues(sampleArray);
        assertEquals(0, trueCount);
    }

    @Test
    public void testOneElementArray(){
        boolean[] sampleArray = {true};
        int trueCount = TrueCounter.countTrueValues(sampleArray);
        assertEquals(1, trueCount);
    }

    @Test
    public void testOnlyFalseArray(){
        boolean[] sampleArray = {false, false, false};
        int trueCount = TrueCounter.countTrueValues(sampleArray);
        assertEquals(0, trueCount);
    }

    @Test
    public void testAllTrueArray(){
        boolean[] sampleArray = {true, true, true, true, true};
        int trueCount = TrueCounter.countTrueValues(sampleArray);
        assertEquals(5, trueCount);
    }
}
