package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestCommonPrefixTest {

    @Test
    public void testLongestCommonPrefix(){
        String[] test1 = {"flower", "flow", "flight"};
        String longestCommonPre = LongestCommonPrefix.longestCommonPrefix(test1);
        assertEquals("fl", longestCommonPre);
    }

    @Test
    public void testNullLongestCommonPrefix(){
        String[] test2 = {"dog", "racecar", "car"};
        String longestCommonPre = LongestCommonPrefix.longestCommonPrefix(test2);
        assertEquals("", longestCommonPre);
    }

    @Test
    public void testNullArray(){
        String[] test2 = null;
        String longestCommonPre = LongestCommonPrefix.longestCommonPrefix(test2);
        assertEquals("", longestCommonPre);
    }

    @Test
    public void testEmptyArrya(){
        String[] test2 = {};
        String longestCommonPre = LongestCommonPrefix.longestCommonPrefix(test2);
        assertEquals("", longestCommonPre);
    }

    @Test
    public void testOneElement(){
        String[] test2 = {"dog"};
        String longestCommonPre = LongestCommonPrefix.longestCommonPrefix(test2);
        assertEquals("dog", longestCommonPre);
    }

    @Test
    public void testEqualWords(){
        String[] test2 = {"dog", "dog", "dog"};
        String longestCommonPre = LongestCommonPrefix.longestCommonPrefix(test2);
        assertEquals("dog", longestCommonPre);
    }

    @Test
    public void testOneDiff(){
        String[] test2 = {"abcd", "abcd", "abcdf"};
        String longestCommonPre = LongestCommonPrefix.longestCommonPrefix(test2);
        assertEquals("abcd", longestCommonPre);
    }

    @Test
    public void testAllEmpty(){
        String[] test2 = {"", "", ""};
        String longestCommonPre = LongestCommonPrefix.longestCommonPrefix(test2);
        assertEquals("", longestCommonPre);
    }

    @Test
    public void testOneEmpty(){
        String[] test2 = {"", "racecar", "car"};
        String longestCommonPre = LongestCommonPrefix.longestCommonPrefix(test2);
        assertEquals("", longestCommonPre);
    }

    @Test
    public void testOneLetter(){
        String[] test2 = {"a", "b", "c"};
        String longestCommonPre = LongestCommonPrefix.longestCommonPrefix(test2);
        assertEquals("", longestCommonPre);
    }

    @Test
    public void testNullValue(){
        String[] test2 = {"dog", null, "car"};
        String longestCommonPre = LongestCommonPrefix.longestCommonPrefix(test2);
        assertEquals("", longestCommonPre);
    }

    @Test
    public void testAllNullValues(){
        String[] test2 = {null, null, null};
        String longestCommonPre = LongestCommonPrefix.longestCommonPrefix(test2);
        assertEquals("", longestCommonPre);
    }
}
