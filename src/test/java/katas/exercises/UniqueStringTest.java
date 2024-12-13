package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UniqueStringTest {

    @Test
    public void testUniqueString(){
        String test1 = "World";
        boolean isUnique = UniqueString.isUnique(test1);
        assertTrue(isUnique);
    }

    @Test
    public void testNotUnique(){
        String test1 = "Hello";
        boolean isUnique = UniqueString.isUnique(test1);
        assertFalse(isUnique);
    }

    @Test
    public void testNullString(){
        String test1 = null;
        boolean isUnique = UniqueString.isUnique(test1);
        assertTrue(isUnique);
    }

    @Test
    public void testEmptyString(){
        String test1 = "";
        boolean isUnique = UniqueString.isUnique(test1);
        assertTrue(isUnique);
    }

    @Test
    public void testOneChar(){
        String test1 = "H";
        boolean isUnique = UniqueString.isUnique(test1);
        assertTrue(isUnique);
    }

    @Test
    public void testCaseSensitive(){
        String test1 = "HeLlo";
        boolean isUnique = UniqueString.isUnique(test1);
        assertFalse(isUnique);
    }

    @Test
    public void testDuplicateChars(){
        String test1 = "aaaa";
        boolean isUnique = UniqueString.isUnique(test1);
        assertFalse(isUnique);
    }


}
