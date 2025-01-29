package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MedianFinderTest {

    @Test
    public void testMedianFinder() {
        MedianFinder medianFinder = new MedianFinder();

        medianFinder.addNum(1);
        medianFinder.addNum(2);
        assertEquals(1.5, medianFinder.findMedian());

        medianFinder.addNum(3);
        assertEquals(2.0, medianFinder.findMedian());

        medianFinder.addNum(5);
        assertEquals(2.5, medianFinder.findMedian());
    }

    @Test
    public void testAllSameElements() {
        MedianFinder medianFinder = new MedianFinder();

        medianFinder.addNum(1);
        medianFinder.addNum(1);
        medianFinder.addNum(1);

        assertEquals(1, medianFinder.findMedian());
    }

    @Test
    public void testEmptyHeap() {
        MedianFinder medianFinder = new MedianFinder();

        assertThrows(IllegalStateException.class, medianFinder::findMedian);
    }

    @Test
    public void testOneElement() {
        MedianFinder medianFinder = new MedianFinder();

        medianFinder.addNum(1);
        assertEquals(1, medianFinder.findMedian());
    }

    @Test
    public void testUnsortedElements() {
        MedianFinder medianFinder = new MedianFinder();

        medianFinder.addNum(30);
        medianFinder.addNum(10);
        medianFinder.addNum(20);

        assertEquals(20.0, medianFinder.findMedian());
    }

    @Test
    public void testNegativeNumbers() {
        MedianFinder medianFinder = new MedianFinder();

        medianFinder.addNum(-30);
        medianFinder.addNum(-10);
        medianFinder.addNum(-20);

        assertEquals(-20.0, medianFinder.findMedian());
    }
}
