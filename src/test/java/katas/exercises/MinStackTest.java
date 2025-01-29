package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinStackTest {

    @Test
    public void testMinStack() {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        assertEquals(-3, stack.getMin());
        stack.pop();
        assertEquals(0, stack.top());
        assertEquals(-2, stack.getMin());
    }

    @Test
    public void testAllEqualValues() {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(-2);
        stack.push(-2);
        assertEquals(-2, stack.getMin());
        stack.pop();
        assertEquals(-2, stack.top());
        assertEquals(-2, stack.getMin());
    }

    @Test
    public void testEmptyStack() {
        MinStack stack = new MinStack();
        assertEquals(-1, stack.getMin());
        stack.pop();
        assertEquals(-1, stack.top());
        assertEquals(-1, stack.getMin());
    }

    @Test
    public void testOneElementStack() {
        MinStack stack = new MinStack();
        stack.push(-2);
        assertEquals(-2, stack.getMin());
        stack.pop();
        assertEquals(-1, stack.top());
        assertEquals(-1, stack.getMin());
    }

    @Test
    public void testPopUntilEmpty() {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(-3);
        stack.pop();
        stack.pop();
        assertEquals(-1, stack.getMin());
        assertEquals(-1, stack.top());
    }

}
