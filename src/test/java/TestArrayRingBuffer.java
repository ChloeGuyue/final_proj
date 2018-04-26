import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void basicTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer(3);
        assertEquals(0, arb.fillCount());
        assertEquals(10, arb.capacity());
        assertTrue(arb.isEmpty());
    }

    @Test
    public void moreTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(10);
        arb.enqueue(4);
        arb.enqueue(5);
        assertEquals(2, arb.fillCount());
        assertFalse(arb.isEmpty());

        arb.dequeue();
        arb.enqueue(7);
        assertEquals(5, (int) arb.peek());
    }

    @Test
    public void testIter() {
        ArrayRingBuffer<Integer> test = new ArrayRingBuffer<>(5);
        test.enqueue(4);
        test.enqueue(5);
        test.dequeue();
        test.enqueue(7);
        test.enqueue(9);
        test.enqueue(10);
        test.dequeue();
        test.enqueue(4);
        test.enqueue(12);
        test.dequeue();
        test.enqueue(9);
        Iterator t = test.iterator();
        while (t.hasNext()) {
            System.out.println(t.next());
        }

    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
