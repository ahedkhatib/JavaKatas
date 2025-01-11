package katas.exercises;

public class CircularBuffer {
    /**
     * Design a circular buffer (ring buffer).
     *
     * The buffer should operate in constant time.
     * When the buffer is full, adding a new element should overwrite the oldest element.
     *
     */

    private int[] buffer;
    private int head;
    private int tail;
    private int size;

    /**
     * Initializes the circular buffer with a fixed capacity.
     *
     * @param capacity the maximum number of elements the buffer can hold
     */
    public CircularBuffer(int capacity) {
        this.buffer = new int[capacity];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    /**
     * Adds an element to the buffer.
     *
     * @param val the value to add
     */
    public void add(int val) {
        if (size == buffer.length) {
            buffer[head] = val;
            head = (head + 1) % buffer.length;
        }
        else {
            buffer[tail] = val;
            tail = (tail + 1) % buffer.length;
            size++;
        }
    }

    /**
     * Retrieves the oldest element from the buffer.
     *
     * @return the oldest element, or -1 if the buffer is empty
     */
    public int get() {
        if (size == 0)
            return -1;
        int val = buffer[head];
        head = (head + 1) % buffer.length;
        size--;
        return val;
    }

    /**
     * Checks if the buffer is full.
     *
     * @return true if the buffer is full, false otherwise
     */
    public boolean isFull() {

        return buffer.length == size;
    }

    /**
     * Checks if the buffer is empty.
     *
     * @return true if the buffer is empty, false otherwise
     */
    public boolean isEmpty() {

        return size == 0;
    }

    public static void main(String[] args) {
        CircularBuffer buffer = new CircularBuffer(3);

        buffer.add(1);
        buffer.add(2);
        buffer.add(3);
        System.out.println(buffer.get()); // Output: 1
        buffer.add(4);
        System.out.println(buffer.get()); // Output: 2
        buffer.add(5);
        System.out.println(buffer.isFull()); // Output: true
    }
}


