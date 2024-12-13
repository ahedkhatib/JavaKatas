package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringDigitSumTest {

    @Test
    public void testStringDigitSum(){
        String input1 = "abc123";
        int sumDigits = StringDigitSum.sumOfDigits(input1);
        assertEquals(6, sumDigits);
    }

    @Test
    public void testNullString(){
        String input1 = null;
        int sumDigits = StringDigitSum.sumOfDigits(input1);
        assertEquals(0, sumDigits);
    }

    @Test
    public void testEmptyString(){
        String input1 = "";
        int sumDigits = StringDigitSum.sumOfDigits(input1);
        assertEquals(0, sumDigits);
    }

    @Test
    public void testNoDigits(){
        String input1 = "No digits here!";
        int sumDigits = StringDigitSum.sumOfDigits(input1);
        assertEquals(0, sumDigits);
    }

    @Test
    public void testAlldigits(){
        String input1 = "10 2 9";
        int sumDigits = StringDigitSum.sumOfDigits(input1);
        assertEquals(12, sumDigits);
    }
}
