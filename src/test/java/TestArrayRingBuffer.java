import org.junit.Test;

import static org.junit.Assert.*;

/**
 * tests the implementation of ArrayRingBuffer class
 */
public class TestArrayRingBuffer {

    @Test
    public void testInitiation() {
        ArrayRingBuffer rb = new ArrayRingBuffer(10);
        assertEquals(0, rb.fillCount());
        assertEquals(10, rb.capacity());
    }

    @Test
    public void testEnqueue() {
        ArrayRingBuffer<Integer> rb = new ArrayRingBuffer(10);
        rb.enqueue(5);
        rb.enqueue(4);
        rb.enqueue(3);
        assertEquals(3, rb.fillCount());
    }

    @Test
    public void testDequeue() {
        ArrayRingBuffer<Integer> rb = new ArrayRingBuffer(10);
        rb.enqueue(1);
        rb.enqueue(2);
        rb.enqueue(3);
        rb.dequeue();
        assertEquals(2, rb.fillCount());
    }

    @Test
    public void testPeek() {
        ArrayRingBuffer<Integer> rb = new ArrayRingBuffer(10);
        rb.enqueue(1);
        rb.enqueue(2);
        rb.enqueue(3);
        assertEquals(1, (int) rb.peek());
    }

    @Test
    public void testEnqueueDequeueWithPeek() {
        ArrayRingBuffer<Integer> rb = new ArrayRingBuffer(10);
        rb.enqueue(1);
        rb.dequeue();
        rb.enqueue(2);
        rb.enqueue(3);
        assertEquals(2, (int) rb.peek());
    }

    @Test
    public void testIter() {
        ArrayRingBuffer<Integer> rb = new ArrayRingBuffer(10);
        rb.enqueue(1);
        rb.enqueue(2);
        rb.enqueue(3);
        for (int i : rb) {
            System.out.println(i);
        }
    }

}
