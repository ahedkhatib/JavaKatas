package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayDifferenceTest {

    @Test
    public void testValidArrayDifference(){
        int[] arr = {10, 3, 5, 6, 20, -2};
        int difference = ArrayDifference.findDifference(arr);
        assertEquals(22, difference);
    }

    @Test
    public void testNullArrayDifference(){
        int[] arr = {};
        int difference = ArrayDifference.findDifference(arr);
        assertEquals(0, difference);
    }

    @Test
    public void testOneElementArrayDifference(){
        int[] arr = {2};
        int difference = ArrayDifference.findDifference(arr);
        assertEquals(0, difference);
    }

    @Test
    public void testAllZeros(){
        int[] arr = {0, 0, 0, 0, 0};
        int difference = ArrayDifference.findDifference(arr);
        assertEquals(0, difference);
    }

    @Test
    public void testAllNegativeNumbers(){
        int[] arr = {-2, -4, -50, -17, -3};
        int difference = ArrayDifference.findDifference(arr);
        assertEquals(48, difference);
    }

}
