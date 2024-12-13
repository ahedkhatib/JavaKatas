package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ArrayReducerTest {

    @Test
    public void testValidArrayReducer(){
        int[] sampleArray = {10, 15, 7, 20, 25};
        int[] expectedArray = {10, 5, -8, 13, 5};
        ArrayReducer.reduceArray(sampleArray);
        assertArrayEquals(expectedArray, sampleArray);
    }

    @Test
    public void testNullArrayReducer(){
        int[] sampleArray = null;
        ArrayReducer.reduceArray(sampleArray);
        assertArrayEquals(null, sampleArray);
    }

    @Test
    public void testEmptyArrayReducer(){
        int[] sampleArray = {};
        int[] expectedArray = {};
        ArrayReducer.reduceArray(sampleArray);
        assertArrayEquals(expectedArray, sampleArray);
    }

    @Test
    public void testOneElementArray(){
        int[] sampleArray = {23};
        int[] expectedArray = {23};
        ArrayReducer.reduceArray(sampleArray);
        assertArrayEquals(expectedArray, sampleArray);
    }

    @Test
    public void testAllZeros(){
        int[] sampleArray = {0, 0, 0, 0, 0, 0};
        int[] expectedArray = {0, 0, 0, 0, 0, 0};
        ArrayReducer.reduceArray(sampleArray);
        assertArrayEquals(expectedArray, sampleArray);
    }

    @Test
    public void testOneDifferent(){
        int[] sampleArray = {50, 0, 0, 0, 0, 0};
        int[] expectedArray = {50, -50, 0, 0, 0, 0};
        ArrayReducer.reduceArray(sampleArray);
        assertArrayEquals(expectedArray, sampleArray);
    }

    @Test
    public void testAllNegative(){
        int[] sampleArray = {-10, -5, -15, 0};
        int[] expectedArray = {-10, 5, -10, 15};
        ArrayReducer.reduceArray(sampleArray);
        assertArrayEquals(expectedArray, sampleArray);
    }

    @Test
    public void testMiddleDifferent(){
        int[] sampleArray = {0, 0, 50, 0, 0, 0};
        int[] expectedArray = {0, 0, 50, -50, 0, 0};
        ArrayReducer.reduceArray(sampleArray);
        assertArrayEquals(expectedArray, sampleArray);
    }

    @Test
    public void testLargeNumbers(){
        int[] sampleArray = {200000, 400000, 800000};
        int[] expectedArray = {200000, 200000, 400000};
        ArrayReducer.reduceArray(sampleArray);
        assertArrayEquals(expectedArray, sampleArray);
    }
}
