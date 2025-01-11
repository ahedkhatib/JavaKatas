package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CircularBufferTest {

    @Test
    void addAndGetTest(){
        CircularBuffer buffer = new CircularBuffer(3);

        buffer.add(1);
        buffer.add(2);
        buffer.add(3);

        assertEquals(1, buffer.get());
        assertEquals(2, buffer.get());
        assertEquals(3, buffer.get());
    }

    @Test
    void overWriteOldestElementTest(){
        CircularBuffer buffer = new CircularBuffer(3);

        buffer.add(1);
        buffer.add(2);
        buffer.add(3);
        buffer.add(4);

        assertEquals(2, buffer.get());
        assertEquals(3, buffer.get());
        assertEquals(4, buffer.get());
    }

    @Test
    void isFullTest(){
        CircularBuffer buffer = new CircularBuffer(3);

        assertFalse(buffer.isFull());


        buffer.add(1);
        buffer.add(2);
        buffer.add(3);

        assertTrue(buffer.isFull());

        assertEquals(1, buffer.get());
        assertFalse(buffer.isFull());
    }

    @Test
    void isEmptyTest(){
        CircularBuffer buffer = new CircularBuffer(3);

        assertTrue(buffer.isEmpty());


        buffer.add(1);
        buffer.add(2);
        buffer.add(3);

        assertFalse(buffer.isEmpty());

        assertEquals(1, buffer.get());
        assertEquals(2, buffer.get());
        assertEquals(3, buffer.get());
        assertTrue(buffer.isEmpty());
    }

    @Test
    void getFromEmptyTest(){
        CircularBuffer buffer = new CircularBuffer(3);

        assertEquals(-1, buffer.get());
    }

    @Test
    void mixedOperationsTest(){
        CircularBuffer buffer = new CircularBuffer(3);

        buffer.add(1);
        buffer.add(2);
        assertEquals(1, buffer.get());
        buffer.add(3);
        buffer.add(4);
        assertEquals(2, buffer.get());
        assertFalse(buffer.isEmpty());
        assertFalse(buffer.isFull());
        buffer.add(5);
        assertTrue(buffer.isFull());
        assertFalse(buffer.isEmpty());
        assertEquals(3, buffer.get());
        assertEquals(4, buffer.get());
        assertEquals(5, buffer.get());
        assertTrue(buffer.isEmpty());
    }

}
