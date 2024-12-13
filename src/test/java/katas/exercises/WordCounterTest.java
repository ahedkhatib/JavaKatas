package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class WordCounterTest {

    @Test
    public void testValidWord(){
        String sentence = "This is a sample sentence for counting words.";
        int wordCount = WordCounter.countWords(sentence);
        assertEquals(8, wordCount);
    }

    @Test
    public void testNullWord(){
        assertEquals(0, WordCounter.countWords(null));
    }

    @Test
    public void testEmptyWord(){
        assertEquals(0, WordCounter.countWords(""));
    }

    @Test
    public void testAllSpace(){
        String sentence = "                  ";
        assertEquals(0, WordCounter.countWords(sentence));
    }

    @Test
    public void testSpaceBegin(){
        String sentence = "                       This is a sample sentence for counting words.";
        assertEquals(8, WordCounter.countWords(sentence));
    }

    @Test
    public void testMultipleSpaces(){
        String sentence = "This    is a    sample   sentence    for counting          words.";
        int wordCount = WordCounter.countWords(sentence);
        assertEquals(8, wordCount);
    }

    @Test
    public void testOneWord(){
        String sentence = "This";
        int wordCount = WordCounter.countWords(sentence);
        assertEquals(1, wordCount);
    }

    @Test
    public void testBeginEndSpaces(){
        String sentence = "        This is a sample sentence for counting words.      ";
        int wordCount = WordCounter.countWords(sentence);
        assertEquals(8, wordCount);
    }
}
