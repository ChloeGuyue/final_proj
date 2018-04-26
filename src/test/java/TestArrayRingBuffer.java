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
}
